package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.LevelEnum
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
 * @param sentenceAmount 
 */
data class CreateUserRequestUserStudyInfo(

    @field:Valid
    @get:JsonProperty("id", required = true) val id: kotlin.Any?,

    @field:Valid
    @get:JsonProperty("uid", required = true) val uid: kotlin.Any?,

    @field:Valid
    @get:JsonProperty("level", required = true) val level: LevelEnum,

    @field:Valid
    @get:JsonProperty("voiceType", required = true) val voiceType: kotlin.Any?,

    @field:Valid
    @get:JsonProperty("sentenceAmount", required = true) val sentenceAmount: kotlin.Any?
    ) {

}

