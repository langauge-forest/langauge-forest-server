package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.NotificationEnum
import org.hibernate.annotations.Filter
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_notification")
@Filter(name = "softDeleteFilter", condition = "deleted_at IS NULL")
class UserNotificationEntity(
    @Id val uid: UUID,

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_preference")
    val notificationPreference: NotificationEnum,
    var cron: String,
    var isActive: Boolean,
) : BaseTimestampEntity()