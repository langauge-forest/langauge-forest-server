package language_forest.repository

import language_forest.entity.StudyPracticeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface StudyPracticeRepository : JpaRepository<StudyPracticeEntity, UUID> {
    // Study ID에 해당하는 score 평균을 구하는 JPA 쿼리
    @Query("SELECT COALESCE(AVG(sp.score), 0) FROM StudyPracticeEntity sp WHERE sp.studyId = :studyId")
    fun getAverageScoreByStudyId(@Param("studyId") studyId: UUID): Double

    fun findByStudyId(studyId: UUID): List<StudyPracticeEntity>
}