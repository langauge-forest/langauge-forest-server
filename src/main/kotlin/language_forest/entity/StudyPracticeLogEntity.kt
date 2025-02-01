package language_forest.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
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

    val score: Int
) : BaseTimestampEntity()