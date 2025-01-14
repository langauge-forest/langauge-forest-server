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
    @Column(name = "id", columnDefinition = "BINARY(16)")
    val id: UUID = UUID(0, 0),

    @Column(name = "uid", columnDefinition = "BINARY(16)", nullable = false)
    val uid: UUID,

    @Column(name = "title", length = 255, nullable = false)
    var title: String,

    @Column(name = "description", length = 255, nullable = false)
    var description: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('SUCCESS','FAIL','SCHEDULE','CANCEL')", nullable = false)
    var status: NotificationStatusEnum,
) : BaseTimestampEntity()