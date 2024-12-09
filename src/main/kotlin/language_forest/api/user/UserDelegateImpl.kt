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
    override fun getUserInfo(): ResponseEntity<UserInfoDto> {
        val userInfo = userService.getUserMe(getUid())
        return ResponseEntity.ok(UserInfoDto(id = userInfo.id, email = userInfo.email))
    }
}