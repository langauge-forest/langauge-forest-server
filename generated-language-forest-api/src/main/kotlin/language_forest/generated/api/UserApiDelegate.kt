package language_forest.generated.api

import language_forest.generated.model.CreateUserRequest
import language_forest.generated.model.UserResponse
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
     * @see UserApi#createUser
     */
    fun createUser(createUserRequest: CreateUserRequest): ResponseEntity<UserResponse> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"occupation\" : \"occupation\",  \"gender\" : \"MALE\",  \"level\" : \"A\",  \"purpose\" : \"purpose\",  \"language\" : \"language\",  \"languageSecond\" : \"languageSecond\",  \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",  \"deletedAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"studyPlace\" : \"studyPlace\",  \"interest\" : \"interest\",  \"nickname\" : \"nickname\",  \"mbti\" : \"mbti\",  \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"yearOfBirth\" : 0}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }

}
