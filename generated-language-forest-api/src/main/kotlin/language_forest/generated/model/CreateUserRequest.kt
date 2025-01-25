package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import language_forest.generated.model.CreateUserNotification
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
 * @param userNotification 
 */
data class CreateUserRequest(

    @field:Valid
    @get:JsonProperty("user", required = true) val user: UpdateUser,

    @field:Valid
    @get:JsonProperty("userInfo", required = true) val userInfo: UpdateUserInfo,

    @field:Valid
    @get:JsonProperty("userStudyInfo", required = true) val userStudyInfo: UpdateUserStudyInfo,

    @field:Valid
    @get:JsonProperty("userNotification", required = true) val userNotification: CreateUserNotification
    ) {

}

