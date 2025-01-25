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
        return userRepository.findByIdOrNull(uid)
    }

    @Transactional(readOnly = true)
    fun getUserInfo(uid: UUID): UserInfoEntity? {
        return userInfoRepository.findByIdOrNull(uid)
    }

    @Transactional(readOnly = true)
    fun getUserStudyInfoByUid(uid: UUID): UserStudyInfoEntity? {
        return userStudyInfoRepository.findByUid(uid)
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

    @Transactional
    fun saveUserNotification(newUserNotificationEntity: UserNotificationEntity): UserNotificationEntity {
        return userNotificationRepository.save(newUserNotificationEntity)
    }
}
