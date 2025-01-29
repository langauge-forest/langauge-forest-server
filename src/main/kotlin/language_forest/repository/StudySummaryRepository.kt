package language_forest.repository

import language_forest.entity.StudySummaryEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StudySummaryRepository : JpaRepository<StudySummaryEntity, UUID> {
}