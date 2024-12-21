package language_forest.api.userInfo

import language_forest.entity.User
import language_forest.generated.api.UserInfoApiDelegate
import language_forest.generated.model.CreateUserInfoRequest
import language_forest.generated.model.UserInfoDto
import language_forest.util.getUid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

// userInfo는 User포함한 다양한 정보가 사용되는 path입니다.
@Component
class UserInfoDelegateImpl(
    private val userInfoService: UserInfoService
) : UserInfoApiDelegate {
    override fun getUserInfoMe(): ResponseEntity<UserInfoDto> {
        val uid = getUid()
        val user = userInfoService.getUser(uid)
        val userStudyLanguage = userInfoService.getUserStudyLanguage(uid)
        return ResponseEntity.ok(
            UserInfoDto(
                id = user.id,
                email = user.email,
                username = user.username,
                birthday = user.birthday,
                gender = user.gender,
                language = user.language,
                studyLanguages = userStudyLanguage
            )
        )
    }

    override fun createUserInfo(createUserInfoRequest: CreateUserInfoRequest): ResponseEntity<UserInfoDto> {
        val uid = getUid()
        val updatedUser = userInfoService.updateUser(
            User(
                id = uid,
                email = createUserInfoRequest.email,
                username = createUserInfoRequest.username,
                birthday = createUserInfoRequest.birthday,
                gender = createUserInfoRequest.gender,
                language = createUserInfoRequest.language
            )
        )
        val updateUserStudyLanguage = userInfoService.creatUserStudyLanguage(


        )



    }

}