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
        profileImage = this.profileImage
    )
}

fun BaseUser.toUserEntity(): UserEntity {
    return UserEntity(
        uid = this.uid,
        nickname = this.nickname,
        language = this.language,
        profileImage = this.profileImage
    )
}