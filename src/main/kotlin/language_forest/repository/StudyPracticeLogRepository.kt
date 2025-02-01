package language_forest.repository

import language_forest.entity.StudyPracticeLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StudyPracticeLogRepository : JpaRepository<StudyPracticeLogEntity, UUID> {
}