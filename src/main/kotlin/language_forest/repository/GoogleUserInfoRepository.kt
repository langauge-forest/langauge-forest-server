package language_forest.repository

import language_forest.entity.GoogleUserInfoEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GoogleUserInfoRepository : JpaRepository<GoogleUserInfoEntity, UUID> {
    fun findByGoogleId(googleId: String): GoogleUserInfoEntity?
}