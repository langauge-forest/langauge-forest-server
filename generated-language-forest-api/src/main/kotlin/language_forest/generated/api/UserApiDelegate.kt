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
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"userInfo\" : {    \"languageSecond\" : \"languageSecond\",    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"occupation\" : \"occupation\",    \"studyPlace\" : \"studyPlace\",    \"gender\" : \"MALE\",    \"interest\" : \"interest\",    \"purpose\" : \"purpose\",    \"mbti\" : \"mbti\",    \"yearOfBirth\" : 0  },  \"createdAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"deletedAt\" : \"2000-01-23T04:56:07.000+00:00\",  \"user\" : {    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"nickname\" : \"nickname\",    \"language\" : \"language\"  },  \"updatedAt\" : \"2000-01-23T04:56:07.000+00:00\"}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }

}
