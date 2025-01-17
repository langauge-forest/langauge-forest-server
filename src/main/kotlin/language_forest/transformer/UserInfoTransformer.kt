package language_forest.transformer

import language_forest.entity.UserInfoEntity
import language_forest.generated.model.BaseUserInfo
import language_forest.generated.model.CreateUserRequestUser
import language_forest.generated.model.CreateUserRequestUserInfo

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


//CreateUserRequestUserInfo
fun UserInfoEntity.toCreateUserRequestUserInfo(): CreateUserRequestUserInfo {
     return CreateUserRequestUserInfo(
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
fun CreateUserRequestUserInfo.toUserInfoEntity(): UserInfoEntity {
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
