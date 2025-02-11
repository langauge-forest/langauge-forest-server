package language_forest.entity

import jakarta.persistence.*
import language_forest.generated.model.PracticeTypeEnum
import java.util.*

@Entity
@Table(name = "study_practice_log")
class StudyPracticeLogEntity(
    @Id
    val id: UUID,

    val studyPracticeId: UUID,

    val problem: String,

    val myAnswer: String,

    val tip: String,

    val score: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "practice_type")
    val practiceType: PracticeTypeEnum
) : BaseTimestampEntity()