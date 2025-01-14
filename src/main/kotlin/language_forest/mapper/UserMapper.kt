package language_forest.mapper

import org.mapstruct.*
import language_forest.entity.UserEntity
import language_forest.generated.model.BaseUser

@Mapper(
    componentModel = "spring",
    config = language_forest.config.GlobalMapperConfig::class
)
interface UserMapper {

    fun fromBaseUser(baseUser: BaseUser): UserEntity

    fun fromEntityToBaseUser(user: UserEntity): BaseUser

}