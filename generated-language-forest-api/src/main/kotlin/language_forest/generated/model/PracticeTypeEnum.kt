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
* practice가 초기 시도인지 재시도인지 구분하는 enum입니다.
* Values: FIRST,RETRY
*/
enum class PracticeTypeEnum(@get:JsonValue val value: kotlin.String) {

    FIRST("FIRST"),
    RETRY("RETRY");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): PracticeTypeEnum {
                return values().first{it -> it.value == value}
        }
    }
}

