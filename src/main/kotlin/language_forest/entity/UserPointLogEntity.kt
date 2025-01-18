package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.PointEnum
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_point_log")
class UserPointLogEntity(
    @Id
    @UuidGenerator
    val id: UUID,

    val uid: UUID,
    val transactionType: PointEnum,
    val amount: Int,

) : BaseTimestampEntity()