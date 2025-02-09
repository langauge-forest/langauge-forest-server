package language_forest.repository

import language_forest.entity.StudyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate
import java.util.UUID

interface StudyRepository : JpaRepository<StudyEntity, UUID> {
    @Query("SELECT COUNT(s) > 0 FROM StudyEntity s WHERE s.uid = :uid AND DATE(CONVERT_TZ(s.createdAt, 'UTC', :timezone)) = :date")
    fun existsByUidAndCreatedAtDate(
        @Param("uid") uid: UUID,
        @Param("date") date: LocalDate,
        @Param("timezone") timezone: String
    ): Boolean

    @Query("SELECT s FROM StudyEntity s WHERE FUNCTION('YEAR', DATE(CONVERT_TZ(s.createdAt, 'UTC', :timezone))) = :year AND FUNCTION('MONTH', DATE(CONVERT_TZ(s.createdAt, 'UTC', :timezone))) = :month")
    fun findStudyByMonthAndYear(
        @Param("year") year: Int,
        @Param("month") month: Int,
        @Param("timezone") timezone: String
    ): List<StudyEntity>
}