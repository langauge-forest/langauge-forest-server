package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * @param nickname 유저 닉네임 (필수)
 * @param language 대표 언어 (필수)
 */
data class UpdateUser(

    @get:JsonProperty("nickname") val nickname: kotlin.String? = null,

    @field:Valid
    @get:JsonProperty("language") val language: LanguageEnum? = null
    ) {

}

