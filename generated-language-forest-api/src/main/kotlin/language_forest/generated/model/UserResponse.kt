package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import language_forest.generated.model.BaseUser
import language_forest.generated.model.BaseUserInfo
import language_forest.generated.model.BaseUserPoint
import language_forest.generated.model.BaseUserStudyInfo
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
 * @param userPoint 
 */
data class UserResponse(

    @field:Valid
    @get:JsonProperty("user") val user: BaseUser? = null,

    @field:Valid
    @get:JsonProperty("userInfo") val userInfo: BaseUserInfo? = null,

    @field:Valid
    @get:JsonProperty("userStudyInfo") val userStudyInfo: BaseUserStudyInfo? = null,

    @field:Valid
    @get:JsonProperty("userPoint") val userPoint: BaseUserPoint? = null
    ) {

}

