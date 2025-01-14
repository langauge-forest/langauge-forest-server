package language_forest.api.user

import language_forest.entity.UserEntity
import language_forest.entity.UserInfoEntity
import language_forest.entity.UserNotificationEntity
import language_forest.entity.UserPointEntity
import language_forest.exception.ForbiddenException
import language_forest.mapper.UserMapper
import language_forest.repository.UserInfoRepository
import language_forest.repository.UserNotificationRepository
import language_forest.repository.UserPointRepository
import language_forest.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userInfoRepository: UserInfoRepository,
    private val userPointRepository: UserPointRepository,
    private val userNotificationRepository: UserNotificationRepository
) {
    @Transactional(readOnly = true)
    fun getUser(uid: UUID): UserEntity {
        return userRepository.findById(uid).orElseThrow {
            throw RuntimeException("User not found for uid: $uid")
        }
    }

    @Transactional
    fun saveUser(newUser: UserEntity): UserEntity {
        return userRepository.save(newUser)
    }

    @Transactional
    fun saveUserInfo(newUserInfo: UserInfoEntity): UserInfoEntity {
        return userInfoRepository.save(newUserInfo)
    }
}
