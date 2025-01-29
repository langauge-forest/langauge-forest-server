package language_forest.api.study

import language_forest.api.user.UserService
import language_forest.generated.api.StudyApiDelegate
import language_forest.generated.model.CreateStudyRequest
import language_forest.generated.model.CreateStudyResponse
import language_forest.generated.model.CreateStudySummaryResponse
import language_forest.generated.model.StudyResponse
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

        return ResponseEntity.status(HttpStatus.CREATED).body(
            CreateStudySummaryResponse(
                summary = summary,
                message = message,
                emoji = emoji,
                tags = tags
            )
        )
    }
}