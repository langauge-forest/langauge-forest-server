package language_forest.transformer

import language_forest.entity.UserInfoEntity
import language_forest.generated.model.BaseUserInfo
import language_forest.generated.model.UpdateUserInfo
import java.util.UUID

// BaseUserInfo
fun UserInfoEntity.toBaseUserInfo(): BaseUserInfo {
    return BaseUserInfo(
        uid = this.uid,
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


fun UpdateUserInfo.toUserInfoEntity(uid: UUID): UserInfoEntity {
    return UserInfoEntity(
        uid = uid,
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
