package language_forest.repository

import language_forest.entity.GoogleUserInfo
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface GoogleUserInfoRepository: JpaRepository<GoogleUserInfo, UUID> {
    fun findByGoogleId(googleId: String): GoogleUserInfo?
}