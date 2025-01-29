package language_forest.repository

import language_forest.entity.UserStudyInfoEntity
import language_forest.repository.softDelete.JpaRepositoryWithSoftDelete
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserStudyInfoRepository : JpaRepositoryWithSoftDelete<UserStudyInfoEntity, UUID> {
    fun findByUid(uid: UUID): UserStudyInfoEntity?
}