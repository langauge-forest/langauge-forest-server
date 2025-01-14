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
 * @param createdAt 생성 일시 (DB 자동)
 * @param updatedAt 수정 일시 (DB 자동)
 * @param deletedAt 삭제 일시 (소프트 딜리트)
 */
data class Timestamped(

    @get:JsonProperty("createdAt") val createdAt: java.time.OffsetDateTime? = null,

    @get:JsonProperty("updatedAt") val updatedAt: java.time.OffsetDateTime? = null,

    @get:JsonProperty("deletedAt") val deletedAt: java.time.OffsetDateTime? = null
    ) {

}

