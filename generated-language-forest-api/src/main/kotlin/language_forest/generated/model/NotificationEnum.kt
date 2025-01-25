package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.JsonCreator
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
* push 알림 타입입니다.
* Values: DAILY_STUDY
*/
enum class NotificationEnum(@get:JsonValue val value: kotlin.String) {

    DAILY_STUDY("DAILY_STUDY");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): NotificationEnum {
                return values().first{it -> it.value == value}
        }
    }
}

