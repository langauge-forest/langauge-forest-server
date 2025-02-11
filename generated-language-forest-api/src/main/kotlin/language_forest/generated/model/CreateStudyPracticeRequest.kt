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
 * @param studySummaryId 
 * @param selectedTag 제시된 태그들 중 유저가 선택한 태그
 */
data class CreateStudyPracticeRequest(

    @get:JsonProperty("studySummaryId", required = true) val studySummaryId: java.util.UUID,

    @get:JsonProperty("selectedTag", required = true) val selectedTag: kotlin.String
    ) {

}

