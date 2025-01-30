package language_forest.entity


import jakarta.persistence.*
import org.hibernate.annotations.Filter
import org.hibernate.annotations.UuidGenerator
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "apple_user_info")
@Filter(name = "softDeleteFilter", condition = "deleted_at IS NULL")
class AppleUserInfoEntity(
    @Id val uid: UUID,

    val appleId: String,
    var email: String?,
    val familyName: String?,
    val givenName: String?,
    val middleName: String?,
    val namePrefix: String?,
    val nameSuffix: String?,
    val nickname: String?,
    val nonce: String?,
    val realUserStatus: Int?,
    val state: String?,
) : BaseTimestampEntity()