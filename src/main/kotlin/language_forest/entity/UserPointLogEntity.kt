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
    @Column(name = "id")
    val id: UUID = UUID(0, 0),

    @UuidGenerator
    @Column(name = "uid")
    val uid: UUID = UUID(0, 0),

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    val transactionType: PointEnum,

    @Column(name = "amount")
    val amount: Int,

) : BaseTimestampEntity()