package language_forest.entity

import BaseTimestampEntity
import jakarta.persistence.*
import language_forest.generated.model.GenderEnum
import language_forest.generated.model.LanguageEnum
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "`user`")
class User(
    @Id
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID(0, 0), // 기본값 설정 (Hibernate가 무시하고 UUID를 할당)

    var email: String? = null,

    var username: String? = null,

    var birthday: LocalDate? = null,

    var gender: GenderEnum? = null,

    var language: LanguageEnum? = null,
) : BaseTimestampEntity() {

    fun updateFrom(other: User) {
        other.email?.let { this.email = it }
        other.username?.let { this.username = it }
        other.birthday?.let { this.birthday = it }
        other.gender?.let { this.gender = it }
        other.language?.let { this.language = it }
    }
}
