package language_forest.repository

import language_forest.entity.UserStudyInfoEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserStudyInfoRepository : JpaRepository<UserStudyInfoEntity, UUID> {
}