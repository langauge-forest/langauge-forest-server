package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.InputTypeEnum
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
 * @param userStudyInfoId 
 * @param startQuestion 시작 질문
 * @param inputType 문장 입력 타입
 * @param story 유저의 하루 일기
 * @param storyVoicePath 유저의 하루 일기 음성 파일 경로
 */
data class CreateStudy(

    @get:JsonProperty("userStudyInfoId", required = true) val userStudyInfoId: java.util.UUID,

    @get:JsonProperty("startQuestion", required = true) val startQuestion: kotlin.String,

    @field:Valid
    @get:JsonProperty("inputType", required = true) val inputType: InputTypeEnum,

    @get:JsonProperty("story", required = true) val story: kotlin.String,

    @get:JsonProperty("storyVoicePath") val storyVoicePath: kotlin.String? = null
    ) {

}

