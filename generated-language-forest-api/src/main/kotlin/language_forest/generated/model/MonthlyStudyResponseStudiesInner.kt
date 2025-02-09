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
 * @param studyId 
 * @param selectedTag 제시된 태그들 중 유저가 선택한 태그
 * @param emoji 하루 일지 기반 이모티콘
 */
data class MonthlyStudyResponseStudiesInner(

    @get:JsonProperty("studyId") val studyId: java.util.UUID? = null,

    @get:JsonProperty("selectedTag") val selectedTag: kotlin.String? = null,

    @get:JsonProperty("emoji") val emoji: kotlin.String? = null
    ) {

}

