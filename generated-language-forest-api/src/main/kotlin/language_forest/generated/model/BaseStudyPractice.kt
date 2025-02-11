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
 * @param id 
 * @param studyId 
 * @param problemNumber 문제 번호
 * @param problem 문제
 * @param correctAnswer 정답
 * @param myAnswer 유저의 답변
 * @param tip 팁(피드백)
 * @param score 점수
 * @param myAnswerVoicePath 유저의 답변 음성 파일 경로
 */
data class BaseStudyPractice(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("studyId", required = true) val studyId: java.util.UUID,

    @get:JsonProperty("problemNumber", required = true) val problemNumber: kotlin.Int,

    @get:JsonProperty("problem", required = true) val problem: kotlin.String,

    @get:JsonProperty("correctAnswer", required = true) val correctAnswer: kotlin.String,

    @get:JsonProperty("myAnswer", required = true) val myAnswer: kotlin.String,

    @get:JsonProperty("tip", required = true) val tip: kotlin.String,

    @get:JsonProperty("score", required = true) val score: kotlin.Int,

    @get:JsonProperty("myAnswerVoicePath") val myAnswerVoicePath: kotlin.String? = null
    ) {

}

