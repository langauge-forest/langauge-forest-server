package language_forest.api.user

import language_forest.entity.UserPointEntity
import language_forest.generated.api.UserApiDelegate
import language_forest.generated.model.*
import language_forest.transformer.*
import language_forest.util.getUid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserDelegateImpl(
    private val userService: UserService,
) : UserApiDelegate {
    override fun createUser(createUserRequest: CreateUserRequest): ResponseEntity<Unit> {
        val uid = getUid()
        val userRequest = createUserRequest.user.toUserEntity(uid)
        val userInfoRequest = createUserRequest.userInfo.toUserInfoEntity(uid)
        val userStudyInfoRequest = createUserRequest
            .userStudyInfo
            .toUserStudyInfoEntity(
                id = UUID.randomUUID(),
                uid = uid
            )
        val userNotificationRequest = createUserRequest
            .userNotification
            .toUserNotificationEntity(
                uid = uid,
                notificationPreference = NotificationEnum.DAILY_STUDY
            )

        val newUserPoint = UserPointEntity(uid = uid, amount = 0)

        userService.onboardingUser(
            newUser = userRequest,
            newUserInfo = userInfoRequest,
            newUserStudyInfo = userStudyInfoRequest,
            newUserNotification =  userNotificationRequest,
            newUserPoint = newUserPoint
        )

        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    override fun getUserMe(): ResponseEntity<UserResponse> {
        val uid = getUid()

        val user = userService.getUser(uid)
        val userInfo = userService.getUserInfo(uid)
        val userStudyInfo = userService.getUserStudyInfoByUid(uid)
        val userPoint = userService.getUserPoint(uid)


        return ResponseEntity.ok(
            UserResponse(
                user = user?.toBaseUser(),
                userInfo = userInfo?.toBaseUserInfo(),
                userStudyInfo = userStudyInfo?.toBaseUserStudyInfo(),
                userPoint = userPoint?.toBaseUserPoint()
            )
        )
    }


    override fun updateUser(updateUserRequest: UpdateUserRequest): ResponseEntity<Unit> {
        val uid = getUid()

        userService.updateUsers(
            uid = uid,
            user = updateUserRequest.user,
            userInfo = updateUserRequest.userInfo,
            userStudyInfo = updateUserRequest.userStudyInfo,
        )

        return ResponseEntity.status(HttpStatus.CREATED).build()

    }

}
