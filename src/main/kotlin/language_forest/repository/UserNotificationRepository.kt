package language_forest.repository

import language_forest.entity.UserNotificationEntity
import language_forest.generated.model.NotificationEnum
import language_forest.repository.softDelete.JpaRepositoryWithSoftDelete
import language_forest.repository.softDelete.SoftDeleteRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserNotificationRepository : JpaRepositoryWithSoftDelete<UserNotificationEntity, UUID> {

    fun findByUidAndNotificationPreference(uid: UUID, notificationPreference: NotificationEnum): UserNotificationEntity?

    @Modifying
    @Query("UPDATE UserNotificationEntity u SET u.isActive = :isActive WHERE u.uid = :uid AND u.notificationPreference = :notificationPreference")
    fun updateIsActiveByUidAndNotificationPreference(uid: UUID, notificationPreference: NotificationEnum, isActive: Boolean): Int
}