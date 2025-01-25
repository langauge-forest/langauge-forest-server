package language_forest.transformer

import language_forest.entity.UserEntity
import language_forest.entity.UserInfoEntity
import language_forest.generated.model.*
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
fun UserEntity.toCreateUserRequestUser(): UpdateUser {
    return UpdateUser(
        nickname = this.nickname,
        language = this.language,
    )
}

fun UpdateUser.toUserEntity(uid: UUID): UserEntity {
    return UserEntity(
        uid = uid,
        nickname = this.nickname ?: "",
        language = this.language ?: LanguageEnum.EN,
    )
}