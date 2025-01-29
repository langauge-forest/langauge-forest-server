package language_forest.repository

import language_forest.entity.UserInfoEntity
import language_forest.repository.softDelete.JpaRepositoryWithSoftDelete
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserInfoRepository : JpaRepositoryWithSoftDelete<UserInfoEntity, UUID> {
}