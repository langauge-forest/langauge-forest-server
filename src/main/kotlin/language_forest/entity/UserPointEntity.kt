package language_forest.entity


import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_point")
open class UserPointEntity(

    @Id
    @UuidGenerator
    @Column(name = "uid", columnDefinition = "BINARY(16)")
    val uid: UUID = UUID(0, 0),

    @Column(name = "amount", nullable = false)
    var amount: Int = 0,
) : BaseTimestampEntity()