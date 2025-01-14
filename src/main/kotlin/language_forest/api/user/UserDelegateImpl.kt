package language_forest.api.user

import language_forest.entity.UserEntity
import language_forest.entity.UserInfoEntity
import language_forest.generated.api.UserApiDelegate
import language_forest.generated.model.CreateUserRequest
import language_forest.generated.model.UserResponse
import language_forest.util.toUtcOffsetDateTime
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UserDelegateImpl(
    private val userService: UserService,
) : UserApiDelegate {
    override fun createUser(createUserRequest: CreateUserRequest): ResponseEntity<UserResponse> {

        val user = UserEntity(
            language = createUserRequest.language,
            nickname = createUserRequest.nickname,
        )
        val userInfo = UserInfoEntity(
            gender = createUserRequest.gender,
            yearOfBirth = createUserRequest.yearOfBirth,
            occupation = createUserRequest.occupation,
            interest = createUserRequest.interest,
            level = createUserRequest.level,
            purpose = createUserRequest.purpose,
            languageSecond = createUserRequest.languageSecond,
            studyPlace = createUserRequest.studyPlace,
            mbti = createUserRequest.mbti,
        )

        userService.saveUser(user)
        userService.saveUserInfo(userInfo)

        return ResponseEntity.ok(
            UserResponse(
                gender = userInfo.gender,
                yearOfBirth = userInfo.yearOfBirth,
                occupation = userInfo.occupation,
                interest = userInfo.interest,
                level = userInfo.level,
                purpose = userInfo.purpose,
                languageSecond = userInfo.languageSecond,
                studyPlace = userInfo.studyPlace,
                mbti = userInfo.mbti,
                uid = userInfo.uid,
                nickname = user.nickname,
                language = user.language,
                createdAt = user.createdAt.toUtcOffsetDateTime(),
                updatedAt = user.updatedAt.toUtcOffsetDateTime(),
                deletedAt = user.deletedAt?.toUtcOffsetDateTime(),
            )

        )
    }
}