package language_forest.entity

import jakarta.persistence.*
import language_forest.generated.model.LanguageEnum
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "`user`")
class UserEntity(
    @Id val uid: UUID,
    var nickname: LanguageEnum = LanguageEnum.EN,
    var language: String = "",
) : BaseTimestampEntity()
