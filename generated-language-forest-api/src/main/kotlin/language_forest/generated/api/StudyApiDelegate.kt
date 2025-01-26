package language_forest.generated.api

import language_forest.generated.model.CreateStudyRequest
import language_forest.generated.model.StudyResponse
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
    fun createStudy(createStudyRequest: CreateStudyRequest): ResponseEntity<StudyResponse> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"study\" : {    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"level\" : \"A\",    \"sentenceAmount\" : 0,    \"inputType\" : \"SPEAKING\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"startQuestion\" : \"startQuestion\",    \"startQuestionVoicePath\" : \"startQuestionVoicePath\",    \"voiceType\" : \"A\"  }}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }

}
