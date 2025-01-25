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
 * @param notificationPreference 
 */
data class CreateUserRequestUserNotificationOneOf(

    @field:Valid
    @get:JsonProperty("uid") val uid: kotlin.Any? = null,

    @field:Valid
    @get:JsonProperty("notificationPreference") val notificationPreference: kotlin.Any? = null
    ) {

}

