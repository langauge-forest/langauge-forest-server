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
* push 상태를 관리하는 enum입니다.
* Values: SUCCESS,FAIL,SCHEDULE,CANCEL
*/
enum class NotificationStatusEnum(@get:JsonValue val value: kotlin.String) {

    SUCCESS("SUCCESS"),
    FAIL("FAIL"),
    SCHEDULE("SCHEDULE"),
    CANCEL("CANCEL");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): NotificationStatusEnum {
                return values().first{it -> it.value == value}
        }
    }
}

