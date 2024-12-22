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
 * @param createdAt 생성 일시
 * @param updatedAt 수정 일시
 * @param deletedAt 삭제 일시
 */
data class BaseUserStudyLanguage(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("uid", required = true) val uid: java.util.UUID,

    @field:Valid
    @get:JsonProperty("language", required = true) val language: LanguageEnum,

    @field:Valid
    @get:JsonProperty("level", required = true) val level: LevelEnum,

    @get:JsonProperty("purpose", required = true) val purpose: kotlin.String,

    @get:JsonProperty("createdAt") val createdAt: java.time.OffsetDateTime? = null,

    @get:JsonProperty("updatedAt") val updatedAt: java.time.OffsetDateTime? = null,

    @get:JsonProperty("deletedAt") val deletedAt: java.time.OffsetDateTime? = null
    ) {

}

