package language_forest.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "study_summary")
class StudySummaryEntity(
    @Id val id: UUID,

    val studyId: UUID,

    val summary: String,

    val message: String,

    val emoji: String,

    val tags: String,

    var selectedTag: String?

) : BaseTimestampEntity()