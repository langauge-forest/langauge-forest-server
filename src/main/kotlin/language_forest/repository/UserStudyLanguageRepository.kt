package language_forest.repository

import language_forest.entity.UserStudyLanguage
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserStudyLanguageRepository : JpaRepository<UserStudyLanguage, UUID> {
    fun findByUid(uid: UUID): List<UserStudyLanguage>
}