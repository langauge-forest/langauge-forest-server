package language_forest.entity

import jakarta.persistence.*
import language_forest.generated.model.GenderEnum
import language_forest.generated.model.LevelEnum
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "user_info")
class UserInfoEntity(
    @Id val uid: UUID,

    var gender: GenderEnum?,
    var yearOfBirth: Int?,
    var occupation: String?,
    var interest: String?,
    var purpose: String?,
    var languageSecond: String?,
    var studyPlace: String?,
    var mbti: String?,
) : BaseTimestampEntity()
