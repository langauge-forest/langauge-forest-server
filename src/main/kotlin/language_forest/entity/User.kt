package language_forest.entity

import BaseTimestampEntity
import jakarta.persistence.*
import language_forest.generated.model.GenderEnum
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
) : BaseTimestampEntity()
