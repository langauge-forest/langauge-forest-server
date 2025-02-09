package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import language_forest.generated.model.UpdateUser
import language_forest.generated.model.UpdateUserInfo
import language_forest.generated.model.UpdateUserStudyInfo
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
 * @param user 
 * @param userInfo 
 * @param userStudyInfo 
 */
data class UpdateUserRequest(

    @field:Valid
    @get:JsonProperty("user") val user: UpdateUser? = null,

    @field:Valid
    @get:JsonProperty("userInfo") val userInfo: UpdateUserInfo? = null,

    @field:Valid
    @get:JsonProperty("userStudyInfo") val userStudyInfo: UpdateUserStudyInfo? = null
    ) {

}

