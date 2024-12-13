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
 * @param id 유저 ID
 * @param email 유저 이메일
 */
data class UserInfoDto(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("email") val email: kotlin.String? = null
    ) {

}

