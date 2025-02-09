package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.PointEnum
import org.hibernate.annotations.Filter
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_point_log")
@Filter(name = "softDeleteFilter", condition = "deleted_at IS NULL")
class UserPointLogEntity(
    @Id val id: UUID,

    val uid: UUID,

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    val transactionType: PointEnum,
    val amount: Int,

) : BaseTimestampEntity()