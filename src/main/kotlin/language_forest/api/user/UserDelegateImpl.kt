package language_forest.api.user

import language_forest.generated.api.UserApiDelegate
import language_forest.generated.model.UserInfoDto
import language_forest.util.getUid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UserDelegateImpl(
    private val userService: UserService
) : UserApiDelegate {
    override fun getUserInfoMe(): ResponseEntity<UserInfoDto> {
        val userInfo = userService.getUserMe(getUid())
        return ResponseEntity.ok(
            UserInfoDto(
                id = userInfo.id,
                email = userInfo.email,
                username = userInfo.username,
                birthday = userInfo.birthday,
                gender = userInfo.gender,
            )
        )
    }

    override fun updateUserInfo(userInfoDto: UserInfoDto): ResponseEntity<UserInfoDto> {
        return super.updateUserInfo(userInfoDto)
    }
}