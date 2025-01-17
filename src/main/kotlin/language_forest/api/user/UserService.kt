package language_forest.api.user

import language_forest.entity.*
import language_forest.exception.ForbiddenException
import language_forest.mapper.UserMapper
import language_forest.repository.*
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

    @Transactional
    fun saveDefaultUserStudyInfo(newUserStudyInfo: UserStudyInfoEntity): UserStudyInfoEntity {
        return userStudyInfoRepository.save(newUserStudyInfo.let {
            UserStudyInfoEntity(
                uid = it.uid,
                level = it.level,
                voiceType = it.voiceType,
                sentenceAmount = it.sentenceAmount,
            )
        })
    }
}
