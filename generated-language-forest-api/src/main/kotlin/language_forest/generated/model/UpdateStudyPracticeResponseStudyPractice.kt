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
 * @param problemNumber 문제 번호
 * @param problem 문제
 * @param myAnswer 유저 답변
 * @param myAnswerVoicePath 유저 답변 링크
 * @param correctAnswer 정답
 * @param score 점수
 * @param tip 팁(피드백)
 */
data class UpdateStudyPracticeResponseStudyPractice(

    @get:JsonProperty("problemNumber") val problemNumber: kotlin.Int? = null,

    @get:JsonProperty("problem") val problem: kotlin.String? = null,

    @get:JsonProperty("myAnswer") val myAnswer: kotlin.String? = null,

    @get:JsonProperty("myAnswerVoicePath") val myAnswerVoicePath: kotlin.String? = null,

    @get:JsonProperty("correctAnswer") val correctAnswer: kotlin.String? = null,

    @get:JsonProperty("score") val score: kotlin.Int? = null,

    @get:JsonProperty("tip") val tip: kotlin.String? = null
    ) {

}

