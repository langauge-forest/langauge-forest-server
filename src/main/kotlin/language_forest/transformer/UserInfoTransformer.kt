package language_forest.transformer

import language_forest.entity.UserInfoEntity
import language_forest.generated.model.BaseUserInfo

fun UserInfoEntity.toBaseUserInfo(): BaseUserInfo {
    return BaseUserInfo(
        gender = this.gender,
        yearOfBirth = this.yearOfBirth,
        occupation = this.occupation,
        interest = this.interest,
        purpose = this.purpose,
        languageSecond = this.languageSecond,
        studyPlace = this.studyPlace,
        mbti = this.mbti
    )
}

fun BaseUserInfo.toUserInfoEntity(): UserInfoEntity {
    return UserInfoEntity(
        gender = this.gender,
        yearOfBirth = this.yearOfBirth,
        occupation = this.occupation,
        interest = this.interest,
        purpose = this.purpose,
        languageSecond = this.languageSecond,
        studyPlace = this.studyPlace,
        mbti = this.mbti
    )
}