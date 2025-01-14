package language_forest.entity


import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "google_user_info")
class GoogleUserInfoEntity(

    @Id
    @UuidGenerator
    @Column(name = "uid", columnDefinition = "BINARY(16)")
    val uid: UUID = UUID(0, 0),

    @Column(name = "google_id", length = 50, nullable = false, unique = true)
    val googleId: String,

    @Column(name = "email", length = 100)
    var email: String? = null,

    @Column(name = "name", length = 50)
    var name: String? = null,

    @Column(name = "picture", length = 100)
    var picture: String? = null,

    @Column(name = "locale", length = 11)
    var locale: String? = null,
) : BaseTimestampEntity()