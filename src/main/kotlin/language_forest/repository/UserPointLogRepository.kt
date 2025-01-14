package language_forest.repository

import language_forest.entity.UserPointLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserPointLogRepository : JpaRepository<UserPointLogEntity, UUID> {
}