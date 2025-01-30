package language_forest.repository

import language_forest.entity.UserPointEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserPointRepository : JpaRepository<UserPointEntity, UUID> {
}