package language_forest.entity


import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_point")
class UserPointEntity(
    @Id
    @UuidGenerator
    @Column(name = "uid")
    val uid: UUID = UUID.randomUUID(),

    @Column(name = "amount")
    var amount: Int = 0,
) : BaseTimestampEntity()