package language_forest.api.user

import language_forest.entity.*
import kotlinx.coroutines.runBlocking
import language_forest.entity.UserPointEntity
import language_forest.exception.NotFoundException
import language_forest.generated.api.UserApiDelegate
import language_forest.generated.model.*
import language_forest.transformer.*
import language_forest.util.getUid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserDelegateImpl(
    private val userService: UserService,
    private val notificationService: NotificationService
) : UserApiDelegate {
    override fun createUser(createUserRequest: CreateUserRequest): ResponseEntity<Unit> {
        val uid = getUid()
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
            uid = uid,
            user = createUserRequest.user,
            userInfo = createUserRequest.userInfo.toUserInfoEntity(uid),
            newUserStudyInfo = userStudyInfoRequest,
            newUserNotification =  userNotificationRequest,
            newUserPoint = newUserPoint,
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

    override fun getUserMeSocial(): ResponseEntity<UserSocialResponse> {
        val uid = getUid()
        val socialInfos = userService.getUserSocialInfo(uid)

        return ResponseEntity.ok(
            UserSocialResponse(
                google = socialInfos.googleUserInfo?.let { UserSocialResponseGoogle(email = it.email) },
                apple = socialInfos.appleUserInfo?.let { UserSocialResponseGoogle(email = it.email) },
            )
        )
    }

    override fun getUserMeNotification(notification: NotificationEnum): ResponseEntity<BaseUserNotification> {
        val uid = getUid()
        val userNotification = notificationService.getNotification(uid, notification)

        return ResponseEntity.ok(userNotification.toBaseUserNotification())
    }

    override fun updateUserNotification(
        notification: NotificationEnum,
        updateUserNotificationRequest: UpdateUserNotificationRequest
    ): ResponseEntity<BaseUserNotification> {
        val uid = getUid()
        val update = notificationService.updateNotification(uid, notification, updateUserNotificationRequest)

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(update.toBaseUserNotification())
    }

    override fun userMeDelete(): ResponseEntity<Unit> {
        val uid = getUid()
        val isDeleted = runBlocking {
            userService.deleteUser(uid)
        }
        if (!isDeleted) {
            throw NotFoundException("$uid 유저의 회원탈퇴에 실패했습니다.")
        }

        return ResponseEntity.status(HttpStatus.OK).build()
    }
}
