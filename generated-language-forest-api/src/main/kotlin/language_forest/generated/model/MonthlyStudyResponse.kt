package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import language_forest.generated.model.MonthlyStudyResponseStudiesInner
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
 * @param studies 
 */
data class MonthlyStudyResponse(

    @field:Valid
    @get:JsonProperty("studies") val studies: kotlin.collections.List<MonthlyStudyResponseStudiesInner>? = null
    ) {

}

