package language_forest.api.user

import language_forest.entity.User
import language_forest.entity.UserStudyLanguage
import language_forest.exception.ForbiddenException
import language_forest.mapper.UserMapper
import language_forest.repository.UserRepository
import language_forest.repository.UserStudyLanguageRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userStudyLanguageRepository: UserStudyLanguageRepository,
    private val userMapper: UserMapper
) {
    fun getUser(uid: UUID): User {
        return userRepository.findById(uid).orElseThrow {
            throw RuntimeException("User not found for uid: $uid")
        }
    }

    @Transactional
    fun updateUser(newUser: User): User {
        val existingUser = getUser(newUser.id)
        existingUser.updateFrom(newUser)

        return userRepository.save(existingUser)
    }

    @Transactional
    fun updateUserStudyLanguage(uid: UUID, studyLanguage: UserStudyLanguage): UserStudyLanguage {
        val existingLanguage = userStudyLanguageRepository.findById(studyLanguage.id).orElseThrow {
            throw RuntimeException("UserStudyLanguage not found for id: ${studyLanguage.id}")
        }

        if (existingLanguage.uid != uid) {
            throw ForbiddenException("정보를 수정할 권한이 없습니다.")
        }

        // 기존 엔터티 업데이트
        existingLanguage.updateFrom(studyLanguage)

        return userStudyLanguageRepository.save(existingLanguage)
    }
}
