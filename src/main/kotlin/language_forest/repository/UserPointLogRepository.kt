package language_forest.repository

import language_forest.entity.UserPointLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserPointLogRepository : JpaRepository<UserPointLogEntity, UUID> {
}