package language_forest.repository

import language_forest.entity.UserNotificationEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserNotificationRepository : JpaRepository<UserNotificationEntity, UUID> {
}