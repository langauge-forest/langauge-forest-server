package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import language_forest.generated.model.CreateStudyPracticeResponseStudyPracticesInner
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
 * @param studyPractices 
 */
data class CreateStudyPracticeResponse(

    @field:Valid
    @get:JsonProperty("studyPractices") val studyPractices: kotlin.collections.List<CreateStudyPracticeResponseStudyPracticesInner>? = null
    ) {

}

