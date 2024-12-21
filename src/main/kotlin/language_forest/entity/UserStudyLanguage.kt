package language_forest.entity

import jakarta.persistence.*
import language_forest.generated.model.BaseUserStudyLanguage
import language_forest.generated.model.LanguageEnum
import language_forest.generated.model.LevelEnum
import java.util.*

@Entity
@Table(name = "user_study_language")
class UserStudyLanguage(
    @Id
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    val uid: UUID,

    @Enumerated(EnumType.STRING)
    var language: LanguageEnum,

    @Enumerated(EnumType.STRING)
    var level: LevelEnum,

    var purpose: String,

)