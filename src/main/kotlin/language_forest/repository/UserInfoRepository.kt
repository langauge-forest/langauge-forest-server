package language_forest.repository

import language_forest.entity.UserInfoEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserInfoRepository : JpaRepository<UserInfoEntity, UUID> {
}