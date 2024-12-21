package language_forest.api.userInfo

import language_forest.entity.User
import language_forest.exception.UnauthorizedException
import language_forest.generated.model.BaseUser
import language_forest.generated.model.BaseUserStudyLanguage
import language_forest.generated.model.UserInfoDto
import language_forest.repository.UserRepository
import language_forest.repository.UserStudyLanguageRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class UserInfoService(
    private val userRepository: UserRepository,
    private val userStudyLanguageRepository: UserStudyLanguageRepository
) {
    fun getUser(uid: UUID): BaseUser {
        val user = userRepository.findById(uid).orElseThrow {
            UnauthorizedException("유저 정보를 찾아올 수 없습니다")
        }

        return BaseUser(
            id = user.id,
            email = user.email,
            username = user.username,
            birthday = user.birthday,
            gender = user.gender,
            language =user.language
        )
    }

    fun getUserStudyLanguage(uid: UUID): List<BaseUserStudyLanguage> {
        val userStudyLanguage = userStudyLanguageRepository.findByUid(uid)
        return userStudyLanguage.map {
            BaseUserStudyLanguage(
                id = it.id,
                uid = it.uid,
                language = it.language,
                level = it.level,
                purpose = it.purpose
            )
        }
    }


    @Transactional
    fun updateUser(user: User): User {
        val existingUser = userRepository.findById(user.id)
            .orElseThrow { IllegalArgumentException("User not found with uid: ${user.id}") }

        existingUser.updateFrom(user)

        return userRepository.save(user)
    }

    @Transactional
    fun creatUserStudyLanguage(uid: UUID) {


    }
}