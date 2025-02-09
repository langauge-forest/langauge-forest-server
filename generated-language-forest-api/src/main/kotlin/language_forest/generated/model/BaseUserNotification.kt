package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.NotificationEnum
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
 * @param isActive 
 */
data class BaseUserNotification(

    @get:JsonProperty("uid", required = true) val uid: java.util.UUID,

    @field:Valid
    @get:JsonProperty("notificationPreference", required = true) val notificationPreference: NotificationEnum,

    @get:JsonProperty("cron", required = true) val cron: kotlin.String,

    @get:JsonProperty("isActive", required = true) val isActive: kotlin.Boolean
    ) {

}

