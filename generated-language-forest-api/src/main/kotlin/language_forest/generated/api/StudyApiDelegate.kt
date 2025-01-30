package language_forest.generated.api

import language_forest.generated.model.CreateStudyPracticeRequest
import language_forest.generated.model.CreateStudyPracticeResponse
import language_forest.generated.model.CreateStudyRequest
import language_forest.generated.model.CreateStudyResponse
import language_forest.generated.model.CreateStudySummaryResponse
import language_forest.generated.model.UpdateStudyPracticeRequest
import language_forest.generated.model.UpdateStudyPracticeResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.core.io.Resource

import java.util.Optional

/**
 * A delegate to be called by the {@link StudyApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@jakarta.annotation.Generated(value = ["org.openapitools.codegen.languages.KotlinSpringServerCodegen"], comments = "Generator version: 7.10.0")
interface StudyApiDelegate {

    fun getRequest(): Optional<NativeWebRequest> = Optional.empty()

    /**
     * @see StudyApi#createStudy
     */
    fun createStudy(createStudyRequest: CreateStudyRequest): ResponseEntity<CreateStudyResponse> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"studyId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see StudyApi#createStudyPractice
     */
    fun createStudyPractice(studyId: java.util.UUID,
        createStudyPracticeRequest: CreateStudyPracticeRequest): ResponseEntity<CreateStudyPracticeResponse> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"studyPractices\" : [ {    \"studyPracticeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"problem\" : \"problem\",    \"problemNumber\" : 0  }, {    \"studyPracticeId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"problem\" : \"problem\",    \"problemNumber\" : 0  } ]}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see StudyApi#createStudySummary
     */
    fun createStudySummary(studyId: java.util.UUID): ResponseEntity<CreateStudySummaryResponse> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"summary\" : \"summary\",  \"studySummaryId\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",  \"emoji\" : \"emoji\",  \"message\" : \"message\",  \"tags\" : \"tags\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see StudyApi#updateStudyPractice
     */
    fun updateStudyPractice(studyId: java.util.UUID,
        studyPracticeId: java.util.UUID,
        updateStudyPracticeRequest: UpdateStudyPracticeRequest): ResponseEntity<UpdateStudyPracticeResponse> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"studyPractice\" : {    \"score\" : 6,    \"problem\" : \"problem\",    \"myAnswerVoicePath\" : \"myAnswerVoicePath\",    \"problemNumber\" : 0,    \"tip\" : \"tip\",    \"myAnswer\" : \"myAnswer\",    \"correctAnswer\" : \"correctAnswer\"  }}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }

}
