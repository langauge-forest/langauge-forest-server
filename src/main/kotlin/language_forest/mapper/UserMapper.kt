package language_forest.mapper

import language_forest.entity.User
import language_forest.generated.model.BaseUser
import language_forest.generated.model.CreateUserInfoRequest
import org.mapstruct.*
import java.util.*

@Mapper(componentModel = "spring")
interface UserMapper {
    fun fromBaseUser(baseUser: BaseUser): User

    fun fromCreateUserInfoRequestToEntity(request: CreateUserInfoRequest, uid: UUID): User

    fun fromEntityToBaseUser(user: User): BaseUser
}
