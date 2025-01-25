package language_forest.transformer

import language_forest.entity.UserNotificationEntity
import language_forest.generated.model.CreateUserRequestUserNotification
import language_forest.generated.model.NotificationEnum
import java.util.*


fun CreateUserRequestUserNotification.toUserNotificationEntity(uid: UUID, notificationPreference: NotificationEnum): UserNotificationEntity {
    return UserNotificationEntity(
        uid = uid,
        notificationPreference = notificationPreference,
        cron = this.cron,
    )
}