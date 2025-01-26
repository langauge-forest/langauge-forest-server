package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.InputTypeEnum
import language_forest.generated.model.LevelEnum
import language_forest.generated.model.VoiceTypeEnum
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
 * @param uid 
 * @param startQuestion 시작 질문
 * @param startQuestionVoicePath 시작 질문 음성 파일 경로
 * @param level 학습 난이도
 * @param voiceType ai 목소리 타입
 * @param sentenceAmount 학습할 문장 수
 * @param inputType 문장 입력 타입
 */
data class BaseStudy(

    @get:JsonProperty("id") val id: java.util.UUID? = null,

    @get:JsonProperty("uid") val uid: java.util.UUID? = null,

    @get:JsonProperty("startQuestion") val startQuestion: kotlin.String? = null,

    @get:JsonProperty("startQuestionVoicePath") val startQuestionVoicePath: kotlin.String? = null,

    @field:Valid
    @get:JsonProperty("level") val level: LevelEnum? = null,

    @field:Valid
    @get:JsonProperty("voiceType") val voiceType: VoiceTypeEnum? = null,

    @get:JsonProperty("sentenceAmount") val sentenceAmount: kotlin.Int? = null,

    @field:Valid
    @get:JsonProperty("inputType") val inputType: InputTypeEnum? = null
    ) {

}

