package language_forest.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "study_practice")
class StudyPracticeEntity(
    @Id val id: UUID,

    val studyId: UUID,

    val problemNumber: Int,

    val problem: String,

    val correctAnswer: String,

    var myAnswer: String?,

    var myAnswerVoicePath: String?,

    var tip: String?,

    var score: Int?
) : BaseTimestampEntity()