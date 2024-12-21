package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.LanguageEnum
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
 * @param language 
 * @param level 
 * @param purpose 학습 목적
 */
data class BaseUserStudyLanguage(

    @get:JsonProperty("id", required = true) val id: java.util.UUID?,

    @get:JsonProperty("uid", required = true) val uid: java.util.UUID,

    @field:Valid
    @get:JsonProperty("language") val language: LanguageEnum? = null,

    @field:Valid
    @get:JsonProperty("level") val level: LevelEnum? = null,

    @get:JsonProperty("purpose") val purpose: kotlin.String? = null
    ) {

}

