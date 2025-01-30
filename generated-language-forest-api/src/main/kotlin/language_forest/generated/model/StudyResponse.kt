package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import language_forest.generated.model.BaseStudy
import language_forest.generated.model.BaseStudyPractice
import language_forest.generated.model.BaseStudySummary
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
 * @param study 
 * @param studySummary 
 * @param studyPractices 
 */
data class StudyResponse(

    @field:Valid
    @get:JsonProperty("study") val study: BaseStudy? = null,

    @field:Valid
    @get:JsonProperty("studySummary") val studySummary: BaseStudySummary? = null,

    @field:Valid
    @get:JsonProperty("studyPractices") val studyPractices: kotlin.collections.List<BaseStudyPractice>? = null
    ) {

}

