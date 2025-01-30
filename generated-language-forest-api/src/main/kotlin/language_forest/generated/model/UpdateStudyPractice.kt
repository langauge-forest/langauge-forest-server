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
 * @param myAnswer 유저의 답변
 * @param myAnswerVoicePath 유저의 답변 음성 파일 경로
 */
data class UpdateStudyPractice(

    @get:JsonProperty("myAnswer", required = true) val myAnswer: kotlin.String,

    @get:JsonProperty("myAnswerVoicePath") val myAnswerVoicePath: kotlin.String? = null
    ) {

}

