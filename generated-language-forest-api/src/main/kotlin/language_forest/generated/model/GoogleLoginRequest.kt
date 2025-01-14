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
 * @param accessToken 
 * @param refreshToken 
 */
data class GoogleLoginRequest(

    @get:JsonProperty("nickname", required = true) val nickname: kotlin.String,

    @get:JsonProperty("language", required = true) val language: kotlin.String,

    @get:JsonProperty("accessToken", required = true) val accessToken: kotlin.String,

    @get:JsonProperty("refreshToken") val refreshToken: kotlin.String? = null
    ) {

}

