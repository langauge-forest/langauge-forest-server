package language_forest.api.study

import language_forest.entity.StudyEntity
import language_forest.generated.api.StudyApiDelegate
import language_forest.generated.model.*
import language_forest.transformer.*
import language_forest.util.getUid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class StudyDelegateImpl(
    private val studyService: StudyService,
) : StudyApiDelegate {
    override fun createStudy(createStudyRequest: CreateStudyRequest): ResponseEntity<StudyResponse> {
        val uid = getUid()
        val id = UUID.randomUUID()
        val studyRequest = createStudyRequest
            .study
            .toStudyEntity(
                uid = uid,
                id = id
            )

        studyService.saveStudy(studyRequest)
        return ResponseEntity.status(HttpStatus.CREATED).build()

//        val savedStudy = studyService.saveStudy(studyRequest)
//        return ResponseEntity.ok(StudyResponse(
//            study = savedStudy.toBaseStudy()
//        ))
    }
}