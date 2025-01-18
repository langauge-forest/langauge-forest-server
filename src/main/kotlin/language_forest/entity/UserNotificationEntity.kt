package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.NotificationEnum
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_notification")
class UserNotificationEntity(
    @Id
    @UuidGenerator
    @Column(name = "uid")
    val uid: UUID = UUID(0, 0),

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_preference")
    val notificationPreference: NotificationEnum,

    @Column(name = "cron")
    var cron: String? = null,
) : BaseTimestampEntity()