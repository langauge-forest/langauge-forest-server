package language_forest.repository

import language_forest.entity.UserNotificationLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserNotificationLogRepository : JpaRepository<UserNotificationLogEntity, UUID> {
}