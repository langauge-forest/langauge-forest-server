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
 * @param uid 
 * @param amount 유저 포인트
 */
data class BaseUserPoint(

    @get:JsonProperty("uid", required = true) val uid: java.util.UUID,

    @get:JsonProperty("amount", required = true) val amount: kotlin.Int
    ) {

}

