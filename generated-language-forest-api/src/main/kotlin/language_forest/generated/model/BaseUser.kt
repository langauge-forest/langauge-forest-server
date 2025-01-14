package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
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
data class BaseUser(

    @get:JsonProperty("nickname", required = true) val nickname: kotlin.String,

    @get:JsonProperty("language", required = true) val language: kotlin.String
    ) {

}

