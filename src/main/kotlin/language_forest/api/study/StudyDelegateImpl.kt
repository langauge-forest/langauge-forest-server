package language_forest.api.study

import language_forest.api.user.UserService
import language_forest.entity.StudyPracticeEntity
import language_forest.entity.StudySummaryEntity
import language_forest.generated.api.StudyApiDelegate
import language_forest.generated.model.*
import language_forest.transformer.toCreateStudyPracticeResponseStudyPracticesInner
import language_forest.transformer.toLanguageString
import language_forest.transformer.toLevelString
import language_forest.transformer.toStudyEntity
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

        val summary = openAiUtil.generateSummary(story)
        val message = openAiUtil.generateMessage(story)
        val emoji = openAiUtil.generateEmoji(story)
        val tags = openAiUtil.generateKeywords(story)

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
        val problemList: List<String> = problems.split(",").map { it.trim() }
        val createStudyPracticeResponseStudyPractices: MutableList<CreateStudyPracticeResponseStudyPracticesInner> = mutableListOf()
        problemList.forEachIndexed() { index, problem ->
//            val correctAnswer = openAiUtil.generateAnswer(problem, studyLanguageString)
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
}