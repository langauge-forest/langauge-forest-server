package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
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
 * @param level 
 * @param voiceType 
 * @param sentenceAmount 학습할 문장 수
 */
data class BaseUserStudyInfo(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("uid", required = true) val uid: java.util.UUID,

    @field:Valid
    @get:JsonProperty("level", required = true) val level: LevelEnum,

    @field:Valid
    @get:JsonProperty("voiceType", required = true) val voiceType: VoiceTypeEnum,

    @get:JsonProperty("sentenceAmount", required = true) val sentenceAmount: kotlin.Int
    ) {

}

