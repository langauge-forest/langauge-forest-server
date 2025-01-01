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
    val id: UUID = UUID(0, 0), // 기본값 설정 (Hibernate가 무시하고 UUID를 할당)

    val uid: UUID,

    @Enumerated(EnumType.STRING)
    var language: LanguageEnum,

    @Enumerated(EnumType.STRING)
    var level: LevelEnum,

    var purpose: String,

) : BaseTimestampEntity() {
    fun updateFrom(other: UserStudyLanguage) {
        other.language.let {this.language = it }
        other.purpose.let {this.purpose = it}
        other.level.let {this.level = it }
    }
}