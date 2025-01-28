package language_forest.api.user

import jakarta.persistence.EntityNotFoundException
import language_forest.entity.*
import language_forest.generated.model.UpdateUser
import language_forest.generated.model.UpdateUserInfo
import language_forest.generated.model.UpdateUserStudyInfo
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

    @Transactional(readOnly = true)
    fun getUserPoint(uid: UUID): UserPointEntity? {
        return userPointRepository.findByIdOrNull(uid)
    }

    @Transactional
    fun onboardingUser(
        newUser: UserEntity,
        newUserInfo: UserInfoEntity,
        newUserStudyInfo: UserStudyInfoEntity,
        newUserNotification: UserNotificationEntity,
        newUserPoint: UserPointEntity
    ) {
        saveUser(newUser)
        saveUserInfo(newUserInfo)
        saveUserStudyInfo(newUserStudyInfo)
        saveUserNotification(newUserNotification)
        saveUserPoint(newUserPoint)
    }


    @Transactional
    fun updateUsers(
        uid: UUID,
        user: UpdateUser?,
        userInfo: UpdateUserInfo?,
        userStudyInfo: UpdateUserStudyInfo?,
    ) {
        userInfo?.let { updateUserInfo(uid, userInfo) }
        user?.let { updateUser(uid, user) }
        userStudyInfo?.let { updateUserStudyInfo(userStudyInfo) }
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

    @Transactional
    fun saveUserPoint(newUserPoint: UserPointEntity): UserPointEntity {
        return userPointRepository.save(newUserPoint)
    }



    @Transactional
    fun updateUser(uid: UUID, updateUser: UpdateUser): UserEntity {
        val user = userRepository.findById(uid)
            .orElseThrow { EntityNotFoundException("User not found for id: $uid") }

        updateUser.language?.let { user.language = it }
        updateUser.nickname?.let { user.nickname = it }

        return userRepository.save(user)
    }

    @Transactional
    fun updateUserInfo(uid: UUID, updateUserInfo: UpdateUserInfo): UserInfoEntity {
        val userInfo = userInfoRepository.findById(uid)
            .orElseThrow { EntityNotFoundException("UserInfo not found for id: $uid") }

        updateUserInfo.gender?.let { userInfo.gender = it }
        updateUserInfo.yearOfBirth?.let { userInfo.yearOfBirth = it }
        updateUserInfo.occupation?.let { userInfo.occupation = it }
        updateUserInfo.interest?.let { userInfo.interest = it }
        updateUserInfo.purpose?.let { userInfo.purpose = it }
        updateUserInfo.languageSecond?.let { userInfo.languageSecond = it }
        updateUserInfo.studyPlace?.let { userInfo.studyPlace = it }
        updateUserInfo.mbti?.let { userInfo.mbti = it }

        return userInfoRepository.save(userInfo)
    }

    @Transactional
    fun updateUserStudyInfo(updateUserStudyInfo: UpdateUserStudyInfo): UserStudyInfoEntity {
        val userStudyInfo = userStudyInfoRepository.findById(updateUserStudyInfo.id)
            .orElseThrow { EntityNotFoundException("UserStudyInfo not found for id: $updateUserStudyInfo.id") }

        updateUserStudyInfo.level?.let { userStudyInfo.level = it }
        updateUserStudyInfo.sentenceAmount?.let { userStudyInfo.sentenceAmount = it }
        updateUserStudyInfo.voiceType?.let { userStudyInfo.voiceType = it }

        return userStudyInfoRepository.save(userStudyInfo)
    }


}