package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.BaseUserStudyLanguage
import language_forest.generated.model.GenderEnum
import language_forest.generated.model.LanguageEnum
import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid

/**
 * 
 * @param id 유저 ID
 * @param email 유저 이메일
 * @param username 유저 이름
 * @param birthday 유저 생년월일 (yyyy-MM-dd)
 * @param gender 
 * @param language 
 * @param studyLanguages 
 */
data class UserInfoDto(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("email") val email: kotlin.String? = null,

    @get:JsonProperty("username") val username: kotlin.String? = null,

    @field:Valid
    @get:JsonProperty("birthday") val birthday: java.time.LocalDate? = null,

    @field:Valid
    @get:JsonProperty("gender") val gender: GenderEnum? = null,

    @field:Valid
    @get:JsonProperty("language") val language: LanguageEnum? = null,

    @field:Valid
    @get:JsonProperty("studyLanguages") val studyLanguages: kotlin.collections.List<BaseUserStudyLanguage>? = null
    ) {

}

