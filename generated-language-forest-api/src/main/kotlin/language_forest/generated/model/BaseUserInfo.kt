package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.LevelEnum
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
 * @param id 유저 ID
 * @param email 유저 이메일
 * @param username 유저 이름
 * @param birthday 유저 생년월일 (yyyy-MM-dd)
 * @param gender 
 */
data class BaseUserInfo(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("email", required = true) val email: kotlin.String,

    @get:JsonProperty("username", required = true) val username: kotlin.String,

    @field:Valid
    @get:JsonProperty("birthday", required = true) val birthday: java.time.LocalDate,

    @field:Valid
    @get:JsonProperty("gender", required = true) val gender: LevelEnum
    ) {

}

