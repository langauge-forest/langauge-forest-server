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
 * @param status HTTP 상태 코드
 * @param message 에러 메시지
 */
data class ErrorResponse(

    @get:JsonProperty("status") val status: kotlin.Int? = null,

    @get:JsonProperty("message") val message: kotlin.String? = null
    ) {

}

