package language_forest.api.user

import language_forest.entity.*
import language_forest.repository.*
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userInfoRepository: UserInfoRepository,
    private val userStudyInfoRepository: UserStudyInfoRepository,
    private val userPointRepository: UserPointRepository,
    private val userNotificationRepository: UserNotificationRepository
) {
    @Transactional(readOnly = true)
    fun getUser(uid: UUID): UserEntity? {
        val user = userRepository.findByIdOrNull(uid)
        return user
    }

    @Transactional(readOnly = true)
    fun getUserInfo(uid: UUID): UserInfoEntity? {
        val user = userInfoRepository.findByIdOrNull(uid)
        return user
    }

    @Transactional(readOnly = true)
    fun getUserStudyInfo(uid: UUID): UserStudyInfoEntity? {
        val user = userStudyInfoRepository.findByIdOrNull(uid)
        return user
    }

    @Transactional
    fun saveUser(newUser: UserEntity): UserEntity {
        return userRepository.save(newUser)
    }

    @Transactional
    fun saveUserInfo(newUserInfo: UserInfoEntity): UserInfoEntity {
        return userInfoRepository.save(newUserInfo)
    }

    @Transactional
    fun saveUserStudyInfo(newUserStudyInfo: UserStudyInfoEntity): UserStudyInfoEntity {
        return userStudyInfoRepository.save(newUserStudyInfo)
    }
}
