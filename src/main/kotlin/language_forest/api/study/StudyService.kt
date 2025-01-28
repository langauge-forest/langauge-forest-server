package language_forest.api.study

import language_forest.entity.StudyEntity
import language_forest.repository.StudyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StudyService(
    private val studyRepository: StudyRepository
) {
    @Transactional
    fun saveStudy(newStudy: StudyEntity): StudyEntity {
        return studyRepository.save(newStudy)
    }
}
