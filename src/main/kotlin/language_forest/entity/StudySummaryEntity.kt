package language_forest.entity

import com.vladmihalcea.hibernate.type.json.JsonStringType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Type
import java.util.*

@Entity
@Table(name = "study_summary")
class StudySummaryEntity(
    @Id val id: UUID,

    val studyId: UUID,

    val summary: String,

    val message: String,

    val emoji: String,

    @Type(value = JsonStringType::class)
    val tags: List<String>?,

    var selectedTag: String?

) : BaseTimestampEntity()