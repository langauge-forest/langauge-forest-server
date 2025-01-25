package language_forest.repository

import language_forest.entity.UserPointEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserPointRepository : JpaRepository<UserPointEntity, UUID> {
}