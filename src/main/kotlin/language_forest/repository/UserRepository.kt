package language_forest.repository

import language_forest.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface UserRepository : JpaRepository<UserEntity, UUID> {
}