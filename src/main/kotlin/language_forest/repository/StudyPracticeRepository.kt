package language_forest.repository

import language_forest.entity.StudyPracticeEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StudyPracticeRepository : JpaRepository<StudyPracticeEntity, UUID> {
}