package language_forest.entity

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "`user`")
class UserEntity(
    @Id
    @UuidGenerator
    @Column(name = "uid")
    val uid: UUID = UUID(0, 0),

    @Column(name = "nickname")
    var nickname: String = "",

    @Column(name = "language")
    var language: String = "",
) : BaseTimestampEntity()
