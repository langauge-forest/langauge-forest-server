package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.NotificationStatusEnum
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "user_notification_log")
class UserNotificationLogEntity(
    @Id val id: UUID,
    val uid: UUID,
    var title: String,
    var description: String,
    var status: NotificationStatusEnum,
) : BaseTimestampEntity()