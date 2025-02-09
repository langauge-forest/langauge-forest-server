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
 * @param language 디바이스의 언어를 가져옵니다.
 * @param appleId 애플 로그인의 정보 중 'user'값을 가져옵니다.
 * @param email email값을 가져옵니다. (비공개 여부와 관계 없이 요청합니다.)
 * @param familyName fullName 중 familyName을 의미합니다.
 * @param givenName fullName 중 givenName을 의미합니다.
 * @param middleName fullName 중 middleName을 의미합니다.
 * @param namePrefix fullName 중 namePrefix을 의미합니다.
 * @param nameSuffix fullName 중 nameSuffix을 의미합니다.
 * @param nickname fullName 중 nickname을 의미합니다.
 * @param nonce 
 * @param realUserStatus 
 * @param state 
 */
data class AppleLoginRequest(

    @get:JsonProperty("language", required = true) val language: kotlin.String,

    @get:JsonProperty("appleId", required = true) val appleId: kotlin.String,

    @get:JsonProperty("email") val email: kotlin.String? = null,

    @get:JsonProperty("familyName") val familyName: kotlin.String? = null,

    @get:JsonProperty("givenName") val givenName: kotlin.String? = null,

    @get:JsonProperty("middleName") val middleName: kotlin.String? = null,

    @get:JsonProperty("namePrefix") val namePrefix: kotlin.String? = null,

    @get:JsonProperty("nameSuffix") val nameSuffix: kotlin.String? = null,

    @get:JsonProperty("nickname") val nickname: kotlin.String? = null,

    @get:JsonProperty("nonce") val nonce: kotlin.String? = null,

    @get:JsonProperty("realUserStatus") val realUserStatus: kotlin.Int? = null,

    @get:JsonProperty("state") val state: kotlin.String? = null
    ) {

}

