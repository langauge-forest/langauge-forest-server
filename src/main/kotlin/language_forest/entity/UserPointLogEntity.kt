package language_forest.entity


import jakarta.persistence.*
import language_forest.generated.model.PointEnum
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_point_log")
open class UserPointLogEntity(
    @Id
    @UuidGenerator
    @Column(name = "id", columnDefinition = "BINARY(16)")
    val id: UUID = UUID(0, 0),

    @Column(name = "uid", columnDefinition = "BINARY(16)", nullable = false)
    val uid: UUID = UUID(0, 0),

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", columnDefinition = "ENUM('DAILY_STUDY')", nullable = false)
    val transactionType: PointEnum,

    @Column(name = "amount", nullable = false)
    var amount: Int,

) : BaseTimestampEntity()