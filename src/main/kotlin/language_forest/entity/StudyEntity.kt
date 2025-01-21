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
    @Id
    @UuidGenerator
    @Column(name = "id")
    val id: UUID = UUID(0, 0),

    @UuidGenerator
    @Column(name = "uid")
    val uid: UUID = UUID(0, 0),

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    var level: LevelEnum,

    @Enumerated(EnumType.STRING)
    @Column(name = "voice_type")
    var voiceType: VoiceTypeEnum,

    @Column(name = "sentence_amount")
    var sentenceAmount: Int,

    @Column(name = "input_type")
    var inputType: InputTypeEnum,

    @Column(name = "start_question")
    var startQuestion: String,

    @Column(name = "start_question_voice_path")
    var startQuestionVoicePath: String,
    ) : BaseTimestampEntity()