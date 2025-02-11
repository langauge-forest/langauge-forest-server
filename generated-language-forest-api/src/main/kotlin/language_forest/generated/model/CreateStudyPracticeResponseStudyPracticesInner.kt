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
 * @param studyPracticeId 
 * @param problemNumber 문제 번호
 * @param problem 문제
 */
data class CreateStudyPracticeResponseStudyPracticesInner(

    @get:JsonProperty("studyPracticeId") val studyPracticeId: java.util.UUID? = null,

    @get:JsonProperty("problemNumber") val problemNumber: kotlin.Int? = null,

    @get:JsonProperty("problem") val problem: kotlin.String? = null
    ) {

}

