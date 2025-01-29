package language_forest.generated.api

import language_forest.generated.model.BaseUserNotification
import language_forest.generated.model.CreateUserRequest
import language_forest.generated.model.ErrorResponse
import language_forest.generated.model.NotificationEnum
import language_forest.generated.model.UpdateUserNotificationActiveRequest
import language_forest.generated.model.UpdateUserRequest
import language_forest.generated.model.UserResponse
import language_forest.generated.model.UserSocialResponse
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
    fun createUser(createUserRequest: CreateUserRequest): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UserApi#getUserMe
     */
    fun getUserMe(): ResponseEntity<UserResponse> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"userInfo\" : {    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"occupation\" : \"occupation\",    \"studyPlace\" : \"studyPlace\",    \"gender\" : \"MALE\",    \"interest\" : [ \"interest\", \"interest\" ],    \"purpose\" : \"purpose\",    \"mbti\" : \"mbti\",    \"yearOfBirth\" : 0  },  \"userPoint\" : {    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"amount\" : 5  },  \"userStudyInfo\" : {    \"streakDays\" : 6,    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"level\" : \"A\",    \"sentenceAmount\" : 1,    \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"voiceType\" : \"A\"  },  \"user\" : {    \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",    \"nickname\" : \"nickname\",    \"language\" : \"JA\",    \"profileImage\" : \"profileImage\"  }}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UserApi#getUserMeNotification
     */
    fun getUserMeNotification(notification: NotificationEnum): ResponseEntity<BaseUserNotification> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"cron\" : \"cron\",  \"uid\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\",  \"notificationPreference\" : \"DAILY_STUDY\",  \"isActive\" : true}")
                    break
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"message\" : \"message\",  \"status\" : 0}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UserApi#getUserMeSocial
     */
    fun getUserMeSocial(): ResponseEntity<UserSocialResponse> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"apple\" : {    \"email\" : \"email\"  },  \"google\" : {    \"email\" : \"email\"  }}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UserApi#updateUser
     */
    fun updateUser(updateUserRequest: UpdateUserRequest): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UserApi#updateUserNotificationActive
     */
    fun updateUserNotificationActive(notification: NotificationEnum,
        updateUserNotificationActiveRequest: UpdateUserNotificationActiveRequest): ResponseEntity<Unit> {
        getRequest().ifPresent { request ->
            for (mediaType in MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"message\" : \"message\",  \"status\" : 0}")
                    break
                }
            }
        }
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }


    /**
     * @see UserApi#userMeDelete
     */
    fun userMeDelete(): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)

    }

}
