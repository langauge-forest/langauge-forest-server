package language_forest.transformer

import language_forest.entity.UserInfoEntity
import language_forest.entity.UserStudyInfoEntity
import language_forest.generated.model.*
import java.util.UUID

//BaseUserStudyInfo
fun UserStudyInfoEntity.toBaseUserStudyInfo(): BaseUserStudyInfo {
    return BaseUserStudyInfo(
        id = this.id,
        uid = this.uid,
        level = this.level,
        voiceType = this.voiceType,
        sentenceAmount = this.sentenceAmount,
    )
}

fun BaseUserStudyInfo.toUserInfoEntity(): UserStudyInfoEntity {
    return UserStudyInfoEntity(
        id = this.id,
        uid = this.uid,
        level = this.level,
        voiceType = this.voiceType,
        sentenceAmount = this.sentenceAmount,
    )
}



fun UserStudyInfoEntity.toCreateUserRequestUserStudyInfo(): CreateUserRequestUserStudyInfo {
    return CreateUserRequestUserStudyInfo(
        id = this.id,
        uid = this.uid,
        level = this.level,
        voiceType = this.voiceType,
        sentenceAmount = this.sentenceAmount,
    )
}

fun CreateUserRequestUserStudyInfo.toUserInfoEntity(id: UUID, uid: UUID): UserStudyInfoEntity {
    return UserStudyInfoEntity(
        id = id,
        uid = uid,
        level = this.level,
        // 기본값을 넣어둡니다.
        voiceType = VoiceTypeEnum.A,
        sentenceAmount = 3,
    )
}
