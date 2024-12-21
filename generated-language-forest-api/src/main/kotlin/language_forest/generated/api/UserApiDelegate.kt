package language_forest.generated.api

import language_forest.generated.model.UpdateUserInfoDto
import language_forest.generated.model.UserInfoDto
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.core.io.Resource

import java.util.Optional

/**
 * A delegate to be called by the {@link UserApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@jakarta.annotation.Generated(value = ["org.openapitools.codegen.languages.KotlinSpringServerCodegen"], comments = "Generator version: 7.10.0")
interface UserApiDelegate {

    fun getRequest(): Optional<NativeWebRequest> = Optional.empty()

    /**
     * @see UserApi#getUserInfo
     */
    fun getUserInfo(): ResponseEntity<UserInfoDto> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"birthday\" : \"2000-01-23\",  \"gender\" : \"gender\",  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",  \"studyLanguages\" : [ {    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"level\" : \"EASY\",    \"purpose\" : \"purpose\",    \"language\" : \"EN\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"  }, {    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"level\" : \"EASY\",    \"purpose\" : \"purpose\",    \"language\" : \"EN\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"  } ],  \"email\" : \"email\",  \"username\" : \"username\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UserApi#updateUserInfo
     */
    fun updateUserInfo(updateUserInfoDto: UpdateUserInfoDto): ResponseEntity<UserInfoDto> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"birthday\" : \"2000-01-23\",  \"gender\" : \"gender\",  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",  \"studyLanguages\" : [ {    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"level\" : \"EASY\",    \"purpose\" : \"purpose\",    \"language\" : \"EN\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"  }, {    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"level\" : \"EASY\",    \"purpose\" : \"purpose\",    \"language\" : \"EN\",    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\"  } ],  \"email\" : \"email\",  \"username\" : \"username\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }

}
