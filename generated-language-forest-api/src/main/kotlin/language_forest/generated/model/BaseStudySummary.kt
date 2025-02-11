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

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("studyId", required = true) val studyId: java.util.UUID,

    @get:JsonProperty("summary", required = true) val summary: kotlin.String,

    @get:JsonProperty("message", required = true) val message: kotlin.String,

    @get:JsonProperty("emoji", required = true) val emoji: kotlin.String,

    @get:JsonProperty("tags", required = true) val tags: kotlin.collections.List<kotlin.String>,

    @get:JsonProperty("selectedTag", required = true) val selectedTag: kotlin.String
    ) {

}

