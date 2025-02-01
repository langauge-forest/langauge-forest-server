package language_forest.api.study

import kotlinx.coroutines.runBlocking
import language_forest.api.user.UserService
import language_forest.entity.StudyPracticeEntity
import language_forest.entity.StudyPracticeLogEntity
import language_forest.entity.StudySummaryEntity
import language_forest.entity.UserPointLogEntity
import language_forest.generated.api.StudyApiDelegate
import language_forest.generated.model.*
import language_forest.transformer.*
import language_forest.util.OpenAiUtil
import language_forest.util.getUid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class StudyDelegateImpl(
    private val studyService: StudyService,
    private val userService: UserService,
    private val openAiUtil: OpenAiUtil
) : StudyApiDelegate {
    override fun createStudy(createStudyRequest: CreateStudyRequest): ResponseEntity<CreateStudyResponse> {
        val uid = getUid()
        val id = UUID.randomUUID()
        val userStudyInfo = userService.getUserStudyInfoById(createStudyRequest.study.userStudyInfoId) ?: throw IllegalArgumentException("UserStudyInfoEntity not found for id: ${createStudyRequest.study.userStudyInfoId}")

        val newStudy = createStudyRequest
            .study
            .toStudyEntity(
                uid = uid,
                id = id,
                userStudyInfo = userStudyInfo
            )
        studyService.saveStudy(newStudy)

        return ResponseEntity.status(HttpStatus.CREATED).body(
            CreateStudyResponse(
                studyId = id
            )
        )
    }

    override fun createStudySummary(studyId: UUID): ResponseEntity<CreateStudySummaryResponse> {
        val study = studyService.getStudyById(studyId) ?: throw IllegalArgumentException("StudyEntity not found for id: ${studyId}")
        val story = study.story

//        val summary = openAiUtil.generateSummary(story)
//        val message = openAiUtil.generateMessage(story)
//        val emoji = openAiUtil.generateEmoji(story)
//        val tags = openAiUtil.generateTags(story)

        val summaryContents = runBlocking {
            openAiUtil.generateSummaryContents(story)
        }
        val summary = summaryContents.first
        val message = summaryContents.second
        val tags = summaryContents.third.first
        val emoji = summaryContents.third.second

        val id = UUID.randomUUID()
        val newStudySummary = StudySummaryEntity(
            id = id,
            studyId = studyId,
            summary = summary,
            message = message,
            emoji = emoji,
            tags = tags,
            selectedTag = null
        )
        studyService.saveStudySummary(newStudySummary)

        return ResponseEntity.status(HttpStatus.CREATED).body(
            CreateStudySummaryResponse(
                studySummaryId = id,
                summary = summary,
                message = message,
                emoji = emoji,
                tags = tags
            )
        )
    }

    override fun createStudyPractice(
        studyId: UUID,
        createStudyPracticeRequest: CreateStudyPracticeRequest
    ): ResponseEntity<CreateStudyPracticeResponse> {
        val selectedTag = createStudyPracticeRequest.selectedTag
        var studySummary = studyService.getStudySummaryById(createStudyPracticeRequest.studySummaryId)?: throw IllegalArgumentException("study summary not found")
        studySummary.selectedTag = selectedTag
        studyService.saveStudySummary(studySummary)

        val study = studyService.getStudyById(studyId) ?: throw IllegalArgumentException("StudyEntity not found for id: ${studyId}")
        val userLanguageString = userService.getUser(getUid())?.language?.toLanguageString() ?: throw IllegalArgumentException("user language not found")
        val studyLanguageString = study.language.toLanguageString()
        val studyLevelString = study.level.toLevelString()
        val sentenceAmount = study.sentenceAmount

        val problems = openAiUtil.generateProblems(study.story, sentenceAmount.toString(), userLanguageString, studyLanguageString, studyLevelString)
        val problemList: List<String> = problems.split(".")
            .map { it.trim() }
            .filter { it.isNotBlank() }

        val createStudyPracticeResponseStudyPractices: MutableList<CreateStudyPracticeResponseStudyPracticesInner> = mutableListOf()
        problemList.forEachIndexed() { index, problem ->
            val id = UUID.randomUUID()
            val newStudyPracticeEntity = StudyPracticeEntity(
                id = id,
                studyId = studyId,
                problemNumber = index+1,
                problem = problem,
                correctAnswer = null, myAnswer = null, myAnswerVoicePath = null, tip = null, score = 0
            )

            studyService.saveStudyPractice(newStudyPracticeEntity)

            createStudyPracticeResponseStudyPractices.add(newStudyPracticeEntity.toCreateStudyPracticeResponseStudyPracticesInner())
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
            CreateStudyPracticeResponse(
                studyPractices = createStudyPracticeResponseStudyPractices.toList()
            )
        )
    }

    override fun updateStudyPractice(
        studyId: UUID,
        studyPracticeId: UUID,
        updateStudyPracticeRequest: UpdateStudyPracticeRequest
    ): ResponseEntity<UpdateStudyPracticeResponse> {
        val study = studyService.getStudyById(studyId)?: throw IllegalArgumentException("study not found")
        val userLanguageString = userService.getUser(getUid())?.language?.toLanguageString() ?: throw IllegalArgumentException("user language not found")
        val studyLanguageString = study.language.toLanguageString()

        val studyPractice = studyService.getStudyPracticeById(studyPracticeId)?: throw IllegalArgumentException("study practice not found")
        val problem = studyPractice.problem

        val myAnswer = updateStudyPracticeRequest.studyPractice.myAnswer
        val myAnswerVoicePath = updateStudyPracticeRequest.studyPractice.myAnswerVoicePath?: ""

        val correctAnswer = openAiUtil.generateAnswer(studyLanguageString, userLanguageString, myAnswer, problem)
        val scoreAndTip = runBlocking {
            openAiUtil.generateScoreAndTip(studyLanguageString, userLanguageString, myAnswer, correctAnswer)
        }
        val score = scoreAndTip.first
        val tip = scoreAndTip.second

        studyPractice.myAnswer = myAnswer
        studyPractice.myAnswerVoicePath = myAnswerVoicePath
        studyPractice.correctAnswer = correctAnswer
        studyPractice.score = score
        studyPractice.tip = tip
        studyService.saveStudyPractice(studyPractice)

        val studyPracticeLogId = UUID.randomUUID()
        val newStudyPracticeLog = StudyPracticeLogEntity(
            id = studyPracticeLogId,
            studyPracticeId = studyPracticeId,
            problem = problem,
            myAnswer = myAnswer,
            tip = tip,
            score = score
        )
        studyService.saveStudyPracticeLog(newStudyPracticeLog)

        return ResponseEntity.status(HttpStatus.CREATED).body(
            UpdateStudyPracticeResponse(
                studyPractice = studyPractice.toUpdateStudyPracticeResponseStudyPractice()
            )
        )
    }

    override fun updateStudyPracticeRetry(
        studyId: UUID,
        studyPracticeId: UUID,
        updateStudyPracticeRequest: UpdateStudyPracticeRequest
    ): ResponseEntity<UpdateStudyPracticeResponse> {
        val study = studyService.getStudyById(studyId)?: throw IllegalArgumentException("study not found")
        val userLanguageString = userService.getUser(getUid())?.language?.toLanguageString() ?: throw IllegalArgumentException("user language not found")
        val studyLanguageString = study.language.toLanguageString()

        val studyPractice = studyService.getStudyPracticeById(studyPracticeId)?: throw IllegalArgumentException("study practice not found")
        val myAnswer = updateStudyPracticeRequest.studyPractice.myAnswer
        val myAnswerVoicePath = updateStudyPracticeRequest.studyPractice.myAnswerVoicePath?: ""

        val correctAnswer = studyPractice.correctAnswer?: throw IllegalArgumentException("correct answer not found")
        val scoreAndTip = runBlocking {
            openAiUtil.generateScoreAndTip(studyLanguageString, userLanguageString, myAnswer, correctAnswer)
        }
        val score = scoreAndTip.first
        val tip = scoreAndTip.second

        studyPractice.myAnswer = myAnswer
        studyPractice.myAnswerVoicePath = myAnswerVoicePath
        studyPractice.score = score
        studyPractice.tip = tip
        studyService.saveStudyPractice(studyPractice)

        val studyPracticeLogId = UUID.randomUUID()
        val newStudyPracticeLog = StudyPracticeLogEntity(
            id = studyPracticeLogId,
            studyPracticeId = studyPracticeId,
            problem = studyPractice.problem,
            myAnswer = myAnswer,
            tip = tip,
            score = score
        )
        studyService.saveStudyPracticeLog(newStudyPracticeLog)

        return ResponseEntity.status(HttpStatus.CREATED).body(
            UpdateStudyPracticeResponse(
                studyPractice = studyPractice.toUpdateStudyPracticeResponseStudyPractice()
            )
        )
    }

    override fun completeStudyPractice(studyId: UUID): ResponseEntity<Unit> {
        val study = studyService.getStudyById(studyId)?: throw IllegalArgumentException("study not found")
        val averageScore = studyService.getAverageScoreByStudyId(studyId)

        study.averageScore = averageScore
        study.studyStatus = StudyStatusEnum.COMPLETED
        studyService.saveStudy(study)

        val studyPractices = studyService.getStudyPracticeListByStudyId(studyId)?: throw IllegalArgumentException("study practice list not found")
        val point = studyPractices.sumOf {
            when {
                (it.score ?: 0) >= 90 -> 3
                (it.score ?: 0) >= 70 -> 2
                (it.score ?: 0) >= 50 -> 1
                else -> 0
            }.toInt()
        }

        val uid = getUid()
        val userPoint = userService.getUserPoint(uid)?: throw IllegalArgumentException("user point not found")
        userPoint.amount += point
        userService.saveUserPoint(userPoint)

        val userPointLogId = UUID.randomUUID()
        val newUserPointLog = UserPointLogEntity(
            id = userPointLogId,
            uid = uid,
            transactionType = PointEnum.DAILY_STUDY,
            amount = point
        )
        userService.saveUserPointLog(newUserPointLog)

        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    override fun getStudy(studyId: UUID): ResponseEntity<StudyResponse> {
        val study = studyService.getStudyById(studyId)?: throw IllegalArgumentException("study not found")
        val baseStudy = study.toBaseStudy()

        val studySummary = studyService.getStudySummaryByStudyId(studyId)?: throw IllegalArgumentException("study summary not found")
        val baseStudySummary = studySummary.toBaseStudySummary()

        val studyPracticeList = studyService.getStudyPracticeListByStudyId(studyId)?: throw IllegalArgumentException("study practice list not found")
        val studyPractices: MutableList<BaseStudyPractice> = mutableListOf()
        studyPracticeList.forEach { studyPractice ->
            studyPractices.add(studyPractice.toBaseStudyPractice())
        }

        return ResponseEntity.ok(
            StudyResponse(
                study = baseStudy,
                studySummary = baseStudySummary,
                studyPractices = studyPractices.toList()
            )
        )
    }
}