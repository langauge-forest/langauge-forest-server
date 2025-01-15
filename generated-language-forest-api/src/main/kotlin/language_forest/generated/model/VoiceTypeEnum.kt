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
* ai 목소리에 맵핑되는 enum입니다.
* Values: A,B,C
*/
enum class VoiceTypeEnum(@get:JsonValue val value: kotlin.String) {

    A("A"),
    B("B"),
    C("C");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): VoiceTypeEnum {
                return values().first{it -> it.value == value}
        }
    }
}

