package language_forest.entity

import jakarta.persistence.*
import language_forest.generated.model.*
import org.hibernate.annotations.UuidGenerator
import java.util.*

@Entity
@Table(name = "study")
class StudyEntity(
    @Id val id: UUID,

    val uid: UUID,

    val userStudyInfoId: UUID,

    @Enumerated(EnumType.STRING)
    @Column(name = "voice_type")
    val voiceType: VoiceTypeEnum,

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    val level: LevelEnum,

    val sentenceAmount: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    val language: LanguageEnum,

    val startQuestion: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "input_type")
    val inputType: InputTypeEnum,

    var story: String,

    var storyVoicePath: String?,

    var averageScore: Double?,

    var point: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "study_status")
    var studyStatus: StudyStatusEnum

) : BaseTimestampEntity()