package language_forest.api.study

import language_forest.entity.StudyEntity
import language_forest.entity.StudyPracticeEntity
import language_forest.entity.StudyPracticeLogEntity
import language_forest.entity.StudySummaryEntity
import language_forest.repository.StudyPracticeLogRepository
import language_forest.repository.StudyPracticeRepository
import language_forest.repository.StudyRepository
import language_forest.repository.StudySummaryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class StudyService(
    private val studyRepository: StudyRepository,
    private val studySummaryRepository: StudySummaryRepository,
    private val studyPracticeRepository: StudyPracticeRepository,
    private val studyPracticeLogRepository: StudyPracticeLogRepository
) {
    @Transactional
    fun saveStudy(newStudy: StudyEntity): StudyEntity {
        return studyRepository.save(newStudy)
    }

    @Transactional(readOnly = true)
    fun getStudyById(id: UUID): StudyEntity? {
        return studyRepository.findByIdOrNull(id)
    }

    @Transactional
    fun saveStudySummary(newStudySummary: StudySummaryEntity): StudySummaryEntity {
        return studySummaryRepository.save(newStudySummary)
    }

    @Transactional
    fun saveStudyPractice(newStudyPractice: StudyPracticeEntity): StudyPracticeEntity {
        return studyPracticeRepository.save(newStudyPractice)
    }

    @Transactional(readOnly = true)
    fun getStudySummaryById(id: UUID): StudySummaryEntity? {
        return studySummaryRepository.findByIdOrNull(id)
    }

    @Transactional(readOnly = true)
    fun getStudyPracticeById(id: UUID): StudyPracticeEntity? {
        return studyPracticeRepository.findByIdOrNull(id)
    }

    @Transactional(readOnly = true)
    fun getAverageScoreByStudyId(studyId: UUID): Double {
        return studyPracticeRepository.getAverageScoreByStudyId(studyId)
    }

    @Transactional(readOnly = true)
    fun getStudySummaryByStudyId(studyId: UUID): StudySummaryEntity? {
        return studySummaryRepository.findByStudyId(studyId)
    }

    @Transactional(readOnly = true)
    fun getStudyPracticeListByStudyId(studyId: UUID): List<StudyPracticeEntity>? {
        return studyPracticeRepository.findByStudyId(studyId)
    }

    @Transactional
    fun saveStudyPracticeLog(newStudyPracticeLog: StudyPracticeLogEntity): StudyPracticeLogEntity {
        return studyPracticeLogRepository.save(newStudyPracticeLog)
    }
}
