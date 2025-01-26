package language_forest.repository

import language_forest.entity.StudyEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface StudyRepository : JpaRepository<StudyEntity, UUID> {
}