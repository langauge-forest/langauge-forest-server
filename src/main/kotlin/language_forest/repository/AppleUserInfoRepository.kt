package language_forest.repository

import language_forest.entity.AppleUserInfoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AppleUserInfoRepository : JpaRepository<AppleUserInfoEntity, UUID> {
    fun findByAppleId(googleId: String): AppleUserInfoEntity?
}