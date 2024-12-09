package language_forest.entity

import BaseTimestampEntity
import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.util.UUID

@Entity
@Table(
    name = "user",
)
class User(
    @Id
    @UuidGenerator
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID.randomUUID(),

    val email: String? = null,
) : BaseTimestampEntity()
