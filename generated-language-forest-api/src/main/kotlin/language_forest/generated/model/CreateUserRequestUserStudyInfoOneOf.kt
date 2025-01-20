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
 * @param uid 
 * @param id 
 * @param voiceType 
 * @param sentenceAmount 
 */
data class CreateUserRequestUserStudyInfoOneOf(

    @field:Valid
    @get:JsonProperty("uid") val uid: kotlin.Any? = null,

    @field:Valid
    @get:JsonProperty("id") val id: kotlin.Any? = null,

    @field:Valid
    @get:JsonProperty("voiceType") val voiceType: kotlin.Any? = null,

    @field:Valid
    @get:JsonProperty("sentenceAmount") val sentenceAmount: kotlin.Any? = null
    ) {

}

