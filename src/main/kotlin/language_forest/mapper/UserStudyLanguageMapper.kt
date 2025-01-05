package language_forest.mapper

import language_forest.entity.UserStudyLanguage
import language_forest.generated.model.BaseUserStudyLanguage
import language_forest.generated.model.CreateUserInfoRequestAllOfStudyLanguagesInner
import language_forest.generated.model.UpdateUserStudyLanguageRequest
import org.mapstruct.*

@Mapper(
    componentModel = "spring",
    config = language_forest.config.GlobalMapperConfig::class
)
interface UserStudyLanguageMapper {

    fun updateRequestToEntity(dto: UpdateUserStudyLanguageRequest): UserStudyLanguage

    fun entityToBaseDto(entity: UserStudyLanguage): BaseUserStudyLanguage

    fun fromCreateUserInfoRequestAllOfStudyLanguagesInnerToEntity(dto: CreateUserInfoRequestAllOfStudyLanguagesInner): UserStudyLanguage

    fun fromBaseDtoToEntity(entity: UserStudyLanguage): BaseUserStudyLanguage
}