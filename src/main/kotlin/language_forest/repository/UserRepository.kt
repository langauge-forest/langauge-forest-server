package language_forest.repository

import language_forest.entity.UserEntity
import language_forest.repository.softDelete.JpaRepositoryWithSoftDelete
import language_forest.repository.softDelete.SoftDeleteRepository
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepositoryWithSoftDelete<UserEntity, UUID> {
}