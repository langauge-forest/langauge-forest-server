package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.NotificationStatusEnum
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "user_notification_log")
class UserNotificationLogEntity(
    @Id
    @UuidGenerator
    @Column(name = "id")
    val id: UUID = UUID(0, 0),

    @UuidGenerator
    @Column(name = "uid")
    val uid: UUID = UUID(0, 0),

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status: NotificationStatusEnum,
) : BaseTimestampEntity()