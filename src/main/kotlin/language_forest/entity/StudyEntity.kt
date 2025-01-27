package language_forest.entity

import jakarta.persistence.*
import language_forest.generated.model.InputTypeEnum
import language_forest.generated.model.LevelEnum
import language_forest.generated.model.VoiceTypeEnum
import org.hibernate.annotations.UuidGenerator
import java.util.*

@Entity
@Table(name = "study")
class StudyEntity(
    @Id val id: UUID,

    val uid: UUID,

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    var level: LevelEnum?,

    @Enumerated(EnumType.STRING)
    @Column(name = "voice_type")
    var voiceType: VoiceTypeEnum?,

    var sentenceAmount: Int?,

    @Enumerated(EnumType.STRING)
    @Column(name = "input_type")
    var inputType: InputTypeEnum?,

    var startQuestion: String?,

    var startQuestionVoicePath: String?,

) : BaseTimestampEntity()