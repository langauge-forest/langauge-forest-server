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
 * @param isActive 
 * @param cron 
 */
data class UpdateUserNotificationRequest(

    @get:JsonProperty("isActive") val isActive: kotlin.Boolean? = null,

    @get:JsonProperty("cron") val cron: kotlin.String? = null
    ) {

}

