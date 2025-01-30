package language_forest.repository

import language_forest.entity.UserEntity
import language_forest.repository.softDelete.JpaRepositoryWithSoftDelete
import language_forest.repository.softDelete.SoftDeleteRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepositoryWithSoftDelete<UserEntity, UUID> {
}