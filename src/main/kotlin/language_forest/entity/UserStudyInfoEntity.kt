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
    @Column(name = "uid", columnDefinition = "BINARY(16)", nullable = false)
    val id: UUID = UUID(0, 0),

    @UuidGenerator
    @Column(name = "uid", columnDefinition = "BINARY(16)", nullable = false)
    val uid: UUID = UUID(0, 0),

    @Enumerated(EnumType.STRING)
    @Column(name = "level", columnDefinition = "ENUM('A','B','C','D','E')")
    var level: LevelEnum,

    @Enumerated(EnumType.STRING)
    @Column(name = "voice_type", columnDefinition = "ENUM")
    var voiceType: VoiceTypeEnum,

    @Column(name = "sentence_amount", columnDefinition = "SMALLINT")
    var sentenceAmount: Int,
) : BaseTimestampEntity()