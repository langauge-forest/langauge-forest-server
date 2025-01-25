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
* 유저가 포인트에 대한 조건을 구분하는 enum입니다.
* Values: DAILY_STUDY
*/
enum class PointEnum(@get:JsonValue val value: kotlin.String) {

    DAILY_STUDY("DAILY_STUDY");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): PointEnum {
                return values().first{it -> it.value == value}
        }
    }
}

