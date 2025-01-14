package language_forest.repository

import language_forest.entity.UserNotificationLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserNotificationLogRepository : JpaRepository<UserNotificationLogEntity, UUID> {
}