package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.NotificationEnum
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_notification")
open class UserNotificationEntity(

    @Id
    @UuidGenerator
    @Column(name = "uid", columnDefinition = "BINARY(16)")
    val uid: UUID = UUID(0, 0),

    @Enumerated(EnumType.STRING)
    @Column(
        name = "notification_preference",
        columnDefinition = "ENUM('DAILY_STUDY')",
        nullable = false
    )
    val notificationPreference: NotificationEnum,

    @Column(name = "cron", length = 50)
    var cron: String? = null,
) : BaseTimestampEntity()