package language_forest.entity

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "`user`")
class UserEntity(
    @Id
    @UuidGenerator
    @Column(name = "uid", columnDefinition = "BINARY(16)")
    val uid: UUID = UUID(0, 0),

    @Column(name = "nickname", length = 50, nullable = false)
    var nickname: String = "",

    @Column(name = "language", length = 5, nullable = false)
    var language: String = "",
) : BaseTimestampEntity()
