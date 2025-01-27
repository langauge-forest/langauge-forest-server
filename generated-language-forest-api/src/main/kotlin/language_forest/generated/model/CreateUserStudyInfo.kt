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
 * @param level 학습 난이도
 * @param language 학습할 언어
 */
data class CreateUserStudyInfo(

    @field:Valid
    @get:JsonProperty("level", required = true) val level: LevelEnum,

    @field:Valid
    @get:JsonProperty("language", required = true) val language: LanguageEnum
    ) {

}

