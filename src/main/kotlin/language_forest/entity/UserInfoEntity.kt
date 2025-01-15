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
    @Column(name = "uid", columnDefinition = "BINARY(16)")
    val uid: UUID = UUID(0, 0),

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "ENUM('MALE','FEMALE','OTHER')")
    var gender: GenderEnum? = null,

    @Column(name = "year_of_birth")
    var yearOfBirth: Int? = null,

    @Column(name = "occupation", length = 255)
    var occupation: String? = null,

    @Column(name = "interest", length = 255)
    var interest: String? = null,

    @Column(name = "purpose", length = 255)
    var purpose: String? = null,

    @Column(name = "language_second", length = 5)
    var languageSecond: String? = null,

    @Column(name = "study_place", length = 10)
    var studyPlace: String? = null,

    @Column(name = "mbti", length = 4)
    var mbti: String? = null,
) : BaseTimestampEntity()
