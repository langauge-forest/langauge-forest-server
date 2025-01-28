package language_forest.api.study

import language_forest.api.user.UserService
import language_forest.generated.api.StudyApiDelegate
import language_forest.generated.model.CreateStudyRequest
import language_forest.generated.model.StudyResponse
import language_forest.transformer.toStudyEntity
import language_forest.util.getUid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class StudyDelegateImpl(
    private val studyService: StudyService,
    private val userService: UserService,
) : StudyApiDelegate {
    override fun createStudy(createStudyRequest: CreateStudyRequest): ResponseEntity<StudyResponse> {
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
            StudyResponse(
                studyId = id
            )
        )
    }

}