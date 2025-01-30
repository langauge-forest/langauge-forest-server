package language_forest.dto

import language_forest.entity.AppleUserInfoEntity
import language_forest.entity.GoogleUserInfoEntity

data class SocialInfoDto(
    val googleUserInfo: GoogleUserInfoEntity?,
    val appleUserInfo: AppleUserInfoEntity?
)