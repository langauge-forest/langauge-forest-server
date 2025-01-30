package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.NotificationStatusEnum
import org.hibernate.annotations.Filter
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "user_notification_log")
@Filter(name = "softDeleteFilter", condition = "deleted_at IS NULL")
class UserNotificationLogEntity(
    @Id val id: UUID,
    val uid: UUID,
    var title: String,
    var description: String,


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: NotificationStatusEnum,
) : BaseTimestampEntity()