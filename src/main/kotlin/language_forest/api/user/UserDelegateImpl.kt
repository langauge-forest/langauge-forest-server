package language_forest.api.user

import language_forest.entity.User
import language_forest.generated.api.UserApiDelegate
import language_forest.generated.model.BaseUser
import language_forest.generated.model.BaseUserStudyLanguage
import language_forest.generated.model.UpdateUserStudyLanguageRequest
import language_forest.mapper.UserMapper
import language_forest.mapper.UserStudyLanguageMapper
import language_forest.util.getUid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserDelegateImpl(
    private val userService: UserService,
    private val userStudyLanguageMapper: UserStudyLanguageMapper,
    private val userMapper: UserMapper
) : UserApiDelegate {
    override fun updateUser(baseUser: BaseUser): ResponseEntity<BaseUser> {
        val updatedUser = userService.updateUser(userMapper.fromBaseUser(baseUser))
        return ResponseEntity.ok(userMapper.fromEntityToBaseUser(updatedUser))
    }

    override fun updateUserStudyLanguage(
        userStudyLanguageId: UUID,
        updateUserStudyLanguageRequest: UpdateUserStudyLanguageRequest
    ): ResponseEntity<BaseUserStudyLanguage> {
        val uid = getUid()

        // Mapper를 통해 DTO → 엔터티 변환
        val entity = userStudyLanguageMapper.updateRequestToEntity(updateUserStudyLanguageRequest)

        // Service에 엔터티 전달
        val updatedEntity = userService.updateUserStudyLanguage(uid, entity)

        // Mapper를 통해 엔터티 → DTO 변환
        val response = userStudyLanguageMapper.entityToBaseDto(updatedEntity)

        return ResponseEntity.ok(response)
    }
}