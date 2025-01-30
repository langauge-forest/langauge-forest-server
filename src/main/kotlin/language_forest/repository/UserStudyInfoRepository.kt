package language_forest.repository

import language_forest.entity.UserStudyInfoEntity
import language_forest.repository.softDelete.JpaRepositoryWithSoftDelete
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserStudyInfoRepository : JpaRepositoryWithSoftDelete<UserStudyInfoEntity, UUID> {
    fun findByUid(uid: UUID): UserStudyInfoEntity?
}