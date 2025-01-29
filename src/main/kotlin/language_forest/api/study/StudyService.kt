package language_forest.api.study

import language_forest.entity.StudyEntity
import language_forest.repository.StudyRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class StudyService(
    private val studyRepository: StudyRepository
) {
    @Transactional
    fun saveStudy(newStudy: StudyEntity): StudyEntity {
        return studyRepository.save(newStudy)
    }

    @Transactional(readOnly = true)
    fun getStudyById(id: UUID): StudyEntity? {
        return studyRepository.findByIdOrNull(id)
    }
}
