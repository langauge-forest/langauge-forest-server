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
    @Column(name = "id")
    val id: UUID = UUID.randomUUID(),

    @UuidGenerator
    @Column(name = "uid")
    val uid: UUID = UUID.randomUUID(),

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    var level: LevelEnum,

    @Enumerated(EnumType.STRING)
    @Column(name = "voice_type")
    var voiceType: VoiceTypeEnum,

    @Column(name = "sentence_amount")
    var sentenceAmount: Int,
) : BaseTimestampEntity()