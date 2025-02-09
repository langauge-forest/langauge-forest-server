package language_forest.transformer

import com.fasterxml.jackson.databind.ser.Serializers.Base
import language_forest.entity.UserNotificationEntity
import language_forest.generated.model.BaseUserNotification
import language_forest.generated.model.CreateUserNotification
import language_forest.generated.model.NotificationEnum
import java.util.*


fun CreateUserNotification.toUserNotificationEntity(uid: UUID, notificationPreference: NotificationEnum): UserNotificationEntity {
    return UserNotificationEntity(
        uid = uid,
        notificationPreference = notificationPreference,
        cron = this.cron,
        // 생성할 때는 기본적으로 active를 true로 한다.
        isActive = true,
    )
}

fun UserNotificationEntity.toBaseUserNotification(): BaseUserNotification {
    return BaseUserNotification(
        uid = this.uid,
        notificationPreference = this.notificationPreference,
        cron = this.cron,
        isActive = this.isActive,
    )

}