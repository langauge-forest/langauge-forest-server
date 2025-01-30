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
 * @param id 
 * @param studyId 
 * @param summary 하루 일지 한 문장 요약
 * @param message 하루 일지 150자 이내 요약
 * @param emoji 하루 일지 기반 이모티콘
 * @param tags 하루 일지 기반 4가지 키워드
 * @param selectedTag 유저가 선택한 키워드
 */
data class BaseStudySummary(

    @get:JsonProperty("id") val id: java.util.UUID? = null,

    @get:JsonProperty("studyId") val studyId: java.util.UUID? = null,

    @get:JsonProperty("summary") val summary: kotlin.String? = null,

    @get:JsonProperty("message") val message: kotlin.String? = null,

    @get:JsonProperty("emoji") val emoji: kotlin.String? = null,

    @get:JsonProperty("tags") val tags: kotlin.String? = null,

    @get:JsonProperty("selectedTag") val selectedTag: kotlin.String? = null
    ) {

}

