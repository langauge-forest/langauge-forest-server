package language_forest.entity

import BaseTimestampEntity
import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(name = "`user`")
class User(
    @Id
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID(0, 0), // 기본값 설정 (Hibernate가 무시하고 UUID를 할당)

    val email: String? = null,
) : BaseTimestampEntity()
