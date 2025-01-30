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
* 학습의 완료 여부를 구분하는 enum입니다.
* Values: PENDING,COMPLETED
*/
enum class StudyStatusEnum(@get:JsonValue val value: kotlin.String) {

    PENDING("PENDING"),
    COMPLETED("COMPLETED");

    companion object {
        @JvmStatic
        @JsonCreator
        fun forValue(value: kotlin.String): StudyStatusEnum {
                return values().first{it -> it.value == value}
        }
    }
}

