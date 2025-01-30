package language_forest.api.user

import language_forest.entity.*
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

    override fun createDummy() : ResponseEntity<Unit> {
        val uid = UUID.randomUUID()

        val user = UserEntity(
            uid = uid,
            nickname = "dummy",
            language = LanguageEnum.KO
        )

        val userInfo = UserInfoEntity(
            uid = uid,
            gender = GenderEnum.OTHER,
            yearOfBirth = 2000,
            occupation = "engineer",
            interest = listOf("nothing"),
            purpose = "just because",
            languageSecond = LanguageEnum.JA,
            studyPlace = "home",
            mbti = "esfj"
        )

        val userStudyInfo = UserStudyInfoEntity(
            id = UUID.randomUUID(),
            uid = uid,
            level = LevelEnum.B,
            voiceType = VoiceTypeEnum.A,
            language = LanguageEnum.EN,
            streakDays = 0,
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

}
