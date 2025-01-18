package language_forest.transformer

import language_forest.entity.UserEntity
import language_forest.entity.UserInfoEntity
import language_forest.generated.model.BaseUser
import language_forest.generated.model.BaseUserInfo
import language_forest.generated.model.CreateUserRequestUser
import java.util.UUID

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
        uid = this.uid,
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

fun CreateUserRequestUser.toUserEntity(uid: UUID): UserEntity {
    return UserEntity(
        uid = uid,
        nickname = this.nickname,
        language = this.language,
    )
}