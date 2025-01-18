package language_forest.entity

import jakarta.persistence.*
import language_forest.generated.model.GenderEnum
import language_forest.generated.model.LevelEnum
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "user_info")
class UserInfoEntity(
    @Id
    @UuidGenerator
    @Column(name = "uid")
    val uid: UUID = UUID(0, 0),

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    var gender: GenderEnum? = null,

    @Column(name = "year_of_birth")
    var yearOfBirth: Int? = null,

    @Column(name = "occupation")
    var occupation: String? = null,

    @Column(name = "interest")
    var interest: String? = null,

    @Column(name = "purpose")
    var purpose: String? = null,

    @Column(name = "language_second")
    var languageSecond: String? = null,

    @Column(name = "study_place")
    var studyPlace: String? = null,

    @Column(name = "mbti")
    var mbti: String? = null,
) : BaseTimestampEntity()
