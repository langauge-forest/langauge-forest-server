package language_forest.entity

import jakarta.persistence.*
import language_forest.generated.model.LevelEnum
import language_forest.generated.model.VoiceTypeEnum
import org.hibernate.annotations.UuidGenerator
import java.util.*

@Entity
@Table(name = "user_study_info")
class UserStudyInfoEntity(
    @Id
    @UuidGenerator
    val id: UUID,

    val uid: UUID,
    var level: LevelEnum,
    var voiceType: VoiceTypeEnum,
    var sentenceAmount: Int,
) : BaseTimestampEntity()
