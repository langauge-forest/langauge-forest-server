package language_forest.generated.api

import language_forest.generated.model.BaseUser
import language_forest.generated.model.BaseUserStudyLanguage
import language_forest.generated.model.UpdateUserStudyLanguageRequest
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
     * @see UserApi#updateUser
     */
    fun updateUser(baseUser: BaseUser): ResponseEntity<BaseUser> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"birthday\" : \"2000-01-23\",  \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"deletedAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"gender\" : \"MALE\",  \"language\" : \"EN\",  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",  \"email\" : \"email\",  \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"username\" : \"username\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UserApi#updateUserStudyLanguage
     */
    fun updateUserStudyLanguage(userStudyLanguageId: java.util.UUID,
        updateUserStudyLanguageRequest: UpdateUserStudyLanguageRequest): ResponseEntity<BaseUserStudyLanguage> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",  \"deletedAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"level\" : \"EASY\",  \"purpose\" : \"purpose\",  \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",  \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }

}
