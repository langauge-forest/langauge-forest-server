package language_forest.api.userInfo

import language_forest.entity.User
import language_forest.entity.UserStudyLanguage
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

    fun getUser(uid: UUID): User {
        return userRepository.findById(uid).orElseThrow {
            throw IllegalArgumentException("User not found for uid: $uid")
        }
    }

    fun getUserStudyLanguage(uid: UUID): List<UserStudyLanguage> {
        return userStudyLanguageRepository.findByUid(uid)
    }

    @Transactional
    fun updateUser(newUser: User): User {
        val oldUser = getUser(newUser.id)
        oldUser.updateFrom(newUser)
        return userRepository.save(oldUser)
    }

    @Transactional
    fun createUserStudyLanguage(uid: UUID, studyLanguage: UserStudyLanguage): UserStudyLanguage {
        val entity = UserStudyLanguage(
            uid = uid,
            language = studyLanguage.language,
            level = studyLanguage.level,
            purpose = studyLanguage.purpose
        )
        return userStudyLanguageRepository.save(entity)
    }
}
