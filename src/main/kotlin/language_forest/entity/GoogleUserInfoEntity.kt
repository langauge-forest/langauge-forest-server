package language_forest.entity


import jakarta.persistence.*
import org.hibernate.annotations.Filter
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "google_user_info")
@Filter(name = "softDeleteFilter", condition = "deleted_at IS NULL")
class GoogleUserInfoEntity(
    @Id val uid: UUID,

    val googleId: String,
    var email: String?,
    var name: String?,
    var picture: String?,
    var locale: String?,
) : BaseTimestampEntity()