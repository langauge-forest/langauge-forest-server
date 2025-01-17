package language_forest.api.user

import language_forest.entity.UserEntity
import language_forest.entity.UserInfoEntity
import language_forest.entity.UserStudyInfoEntity
import language_forest.generated.api.UserApiDelegate
import language_forest.generated.model.*
import language_forest.mapper.UserMapper
import language_forest.transformer.toUserInfoEntity
import language_forest.util.getUid
import language_forest.util.toUtcOffsetDateTime
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UserDelegateImpl(
    private val userService: UserService,
    private val userMapper: UserMapper,
) : UserApiDelegate {
    override fun createUser(createUserRequest: CreateUserRequest): ResponseEntity<UserResponse> {
        val uid = getUid()
        val userRequest = createUserRequest.user
        val userInfoRequest = createUserRequest.userInfo
        val userStudyInfoRequest = createUserRequest.userStudyInfo

        val user  = userRequest.let {
            UserEntity(
                uid = uid,
                language = it.language,
                nickname = it.nickname,
            )
        }

        val userInfo = userInfoRequest.toUserInfoEntity()

        val userStudyInfo = userStudyInfoRequest.let {
            UserStudyInfoEntity(
                uid = uid,
                level = it.level,
                voiceType = VoiceTypeEnum.A,
                sentenceAmount = 3,
            )
        }

        val savedUser = userService.saveUser(user)
        val savedUserInfo = userService.saveUserInfo(userInfo)
        val savedUserStudyInfo = userService.saveDefaultUserStudyInfo(userStudyInfo)

        return ResponseEntity.ok(UserResponse(
            user = savedUser.let {
                BaseUser(
                    nickname = it.nickname,
                    language = it.language
                )
            },
            userInfo = savedUserInfo.let {
                BaseUserInfo(

                    gender = it.gender,
                    yearOfBirth = it.yearOfBirth,
                    occupation = it.occupation,
                    interest = it.interest,
                    purpose = it.purpose,
                    languageSecond = it.languageSecond,
                    studyPlace = it.studyPlace,
                    mbti = it.mbti
                )
            },
        ))
    }
}