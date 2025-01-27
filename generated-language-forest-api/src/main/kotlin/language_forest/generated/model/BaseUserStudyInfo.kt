package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.LanguageEnum
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
 * @param level 학습 난이도
 * @param voiceType ai 목소리 타입
 * @param language 지금 내가 학습하는 언어
 * @param streakDays 연속 학습 일 수
 * @param sentenceAmount 학습할 문장 수
 */
data class BaseUserStudyInfo(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("uid", required = true) val uid: java.util.UUID,

    @field:Valid
    @get:JsonProperty("level", required = true) val level: LevelEnum,

    @field:Valid
    @get:JsonProperty("voiceType", required = true) val voiceType: VoiceTypeEnum,

    @field:Valid
    @get:JsonProperty("language", required = true) val language: LanguageEnum,

    @get:JsonProperty("streakDays", required = true) val streakDays: kotlin.Int,

    @get:JsonProperty("sentenceAmount", required = true) val sentenceAmount: kotlin.Int
    ) {

}

