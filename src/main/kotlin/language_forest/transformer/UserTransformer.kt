package language_forest.transformer

import language_forest.entity.UserEntity
import language_forest.entity.UserInfoEntity
import language_forest.generated.model.BaseUser
import language_forest.generated.model.BaseUserInfo
import language_forest.generated.model.CreateUserRequestUser

//BaseUser
fun UserEntity.toBaseUser(): BaseUser {
    return BaseUser(
        uid = this.uid,
        nickname = this.nickname,
        language = this.language,
    )
}

fun BaseUser.toUserEntity(): UserEntity {
    return UserEntity(
        nickname = this.nickname,
        language = this.language,
    )
}

//CreateUserRequestUser
fun UserEntity.toCreateUserRequestUser(): CreateUserRequestUser {
    return CreateUserRequestUser(
        uid = this.uid,
        nickname = this.nickname,
        language = this.language,
    )
}

fun CreateUserRequestUser.toUserEntity(): UserEntity {
    return UserEntity(
        nickname = this.nickname,
        language = this.language,
    )
}