package language_forest.transformer

import language_forest.entity.UserInfoEntity
import language_forest.entity.UserStudyInfoEntity
import language_forest.generated.model.BaseUserInfo
import language_forest.generated.model.BaseUserStudyInfo

fun UserStudyInfoEntity.toBaseUserStudyInfo(): BaseUserStudyInfo {
    return BaseUserStudyInfo(
        level = this.level,
        voiceType = this.voiceType,
        sentenceAmount = this.sentenceAmount,
    )
}

fun BaseUserStudyInfo.toUserInfoEntity(): UserStudyInfoEntity {
    return UserStudyInfoEntity(
        level = this.level,
        voiceType = this.voiceType,
        sentenceAmount = this.sentenceAmount,
    )
}