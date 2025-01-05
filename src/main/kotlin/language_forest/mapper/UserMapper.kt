package language_forest.mapper

import org.mapstruct.*
import language_forest.entity.User
import language_forest.generated.model.BaseUser
import language_forest.generated.model.CreateUserInfoRequest

@Mapper(
    componentModel = "spring",
    config = language_forest.config.GlobalMapperConfig::class
)
interface UserMapper {

    fun fromBaseUser(baseUser: BaseUser): User

    fun fromEntityToBaseUser(user: User): BaseUser

    fun fromCreateUserInfoRequestToEntity(createUserInfoRequest: CreateUserInfoRequest): User
}