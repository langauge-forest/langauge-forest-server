package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.NotificationEnum
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_notification")
class UserNotificationEntity(
    @Id val uid: UUID,
    val notificationPreference: NotificationEnum,
    var cron: String?,
) : BaseTimestampEntity()