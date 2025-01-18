package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.LanguageEnum
import language_forest.generated.model.TokenDto
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
 * @param language 디바이스의 언어를 가져옵니다.
 * @param token 
 */
data class GoogleLoginRequest(

    @field:Valid
    @get:JsonProperty("language", required = true) val language: LanguageEnum,

    @field:Valid
    @get:JsonProperty("token", required = true) val token: TokenDto
    ) {

}

