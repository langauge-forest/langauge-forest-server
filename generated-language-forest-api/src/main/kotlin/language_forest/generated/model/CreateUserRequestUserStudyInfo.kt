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
 * @param level 
 * @param voiceType 
 * @param sentenceAmount 
 * @param id 
 * @param uid 
 */
data class CreateUserRequestUserStudyInfo(

    @field:Valid
    @get:JsonProperty("level", required = true) val level: LevelEnum,

    @field:Valid
    @get:JsonProperty("voiceType", required = true) val voiceType: kotlin.Any?,

    @field:Valid
    @get:JsonProperty("sentenceAmount", required = true) val sentenceAmount: kotlin.Any?,

    @field:Valid
    @get:JsonProperty("id") val id: kotlin.Any? = null,

    @field:Valid
    @get:JsonProperty("uid") val uid: kotlin.Any? = null
    ) {

}

