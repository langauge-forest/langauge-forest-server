package language_forest.entity

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "`user`")
class UserEntity(
    @Id val uid: UUID,
    var nickname: String = "",
    var language: String = "",
) : BaseTimestampEntity()
