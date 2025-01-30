package language_forest.api.user

import language_forest.entity.UserNotificationEntity
import language_forest.exception.BadRequestException
import language_forest.exception.NotFoundException
import language_forest.exception.UpdateFailedException
import language_forest.generated.model.NotificationEnum
import language_forest.generated.model.UpdateUserNotificationRequest
import language_forest.repository.UserNotificationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class NotificationService(
    private val userNotificationRepository: UserNotificationRepository
) {
    @Transactional(readOnly = true)
    fun getNotification(uid: UUID, notificationPreference: NotificationEnum): UserNotificationEntity {
        return userNotificationRepository.findByUidAndNotificationPreference(uid, notificationPreference) ?: throw NotFoundException("${uid}dml ${notificationPreference}을 찾을 수 없습니다.")
    }

    @Transactional
    fun updateNotification(uid: UUID, notificationPreference: NotificationEnum, updateUserNotification: UpdateUserNotificationRequest): UserNotificationEntity {
        val userNotification = userNotificationRepository.findByUidAndNotificationPreference(uid, notificationPreference)
            ?: throw NotFoundException("$uid 의 $notificationPreference 을 찾을 수 없습니다.")

        updateUserNotification.isActive?.let {userNotification.isActive = it}
        updateUserNotification.cron?.let {userNotification.cron = it}

        return userNotificationRepository.save(userNotification)
    }
}