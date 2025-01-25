package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import language_forest.generated.model.BaseUserNotification
import language_forest.generated.model.CreateUserRequestUserNotificationOneOf
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
 * @param cron 
 */
data class CreateUserRequestUserNotification(

    @field:Valid
    @get:JsonProperty("uid", required = true) val uid: kotlin.Any?,

    @field:Valid
    @get:JsonProperty("notificationPreference", required = true) val notificationPreference: kotlin.Any?,

    @get:JsonProperty("cron", required = true) val cron: kotlin.String
    ) {

}

