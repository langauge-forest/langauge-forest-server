package language_forest.api.user

import language_forest.entity.UserEntity
import language_forest.entity.UserInfoEntity
import language_forest.entity.UserNotificationEntity
import language_forest.entity.UserStudyInfoEntity
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
    override fun createDummy(): ResponseEntity<Unit> {
        val uid = UUID.randomUUID()

        val user = UserEntity(
            uid = uid,
            nickname = "dummy",
            language =LanguageEnum.EN
        )

        val userInfo = UserInfoEntity(
            uid = uid,
            gender = GenderEnum.OTHER,
            yearOfBirth = 2000,
            occupation = "engineer",
            interest = "nothing",
            purpose = "just because",
            languageSecond = LanguageEnum.JA,
            studyPlace = "home",
            mbti = "esfj"
        )

        val userStudyInfo = UserStudyInfoEntity(
            id = UUID.randomUUID(),
            uid = uid,
            level = LevelEnum.A,
            voiceType = VoiceTypeEnum.A,
            sentenceAmount = 3
        )

        val userNotification = UserNotificationEntity(
            uid = uid,
            notificationPreference = NotificationEnum.DAILY_STUDY,
            cron = "0 0 12 * * ?"
        )

        userService.saveUser(user)
        userService.saveUserInfo(userInfo)
        userService.saveUserStudyInfo(userStudyInfo)
        userService.saveUserNotification(userNotification)

        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

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

        userService.saveUser(userRequest)
        userService.saveUserInfo(userInfoRequest)
        userService.saveUserStudyInfo(userStudyInfoRequest)
        userService.saveUserNotification(userNotificationRequest)

        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    override fun getUserMe(): ResponseEntity<UserResponse> {
        val uid = getUid()

        val user = userService.getUser(uid)
        val userInfo = userService.getUserInfo(uid)
        val userStudyInfo = userService.getUserStudyInfoByUid(uid)


        return ResponseEntity.ok(
            UserResponse(
                user = user?.toBaseUser(),
                userInfo = userInfo?.toBaseUserInfo(),
                userStudyInfo = userStudyInfo?.toBaseUserStudyInfo()
            )
        )
    }

}