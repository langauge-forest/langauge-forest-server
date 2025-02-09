package language_forest.generated.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import language_forest.generated.model.InputTypeEnum
import language_forest.generated.model.LanguageEnum
import language_forest.generated.model.LevelEnum
import language_forest.generated.model.StudyStatusEnum
import language_forest.generated.model.VoiceTypeEnum
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
 * @param id 
 * @param uid 
 * @param userStudyInfoId 
 * @param voiceType ai 목소리 타입
 * @param level 학습 난이도
 * @param sentenceAmount 학습할 문장 수
 * @param language 지금 내가 학습하는 언어
 * @param startQuestion 시작 질문
 * @param inputType 문장 입력 타입
 * @param story 유저의 하루 일기
 * @param averageScore 전체 점수 평균
 * @param point 학습 완료로 획득한 재화의 양
 * @param studyStatus 학습 상태
 * @param storyVoicePath 유저의 하루 일기 음성 파일 경로
 */
data class BaseStudy(

    @get:JsonProperty("id", required = true) val id: java.util.UUID,

    @get:JsonProperty("uid", required = true) val uid: java.util.UUID,

    @get:JsonProperty("userStudyInfoId", required = true) val userStudyInfoId: java.util.UUID,

    @field:Valid
    @get:JsonProperty("voiceType", required = true) val voiceType: VoiceTypeEnum,

    @field:Valid
    @get:JsonProperty("level", required = true) val level: LevelEnum,

    @get:JsonProperty("sentenceAmount", required = true) val sentenceAmount: kotlin.Int,

    @field:Valid
    @get:JsonProperty("language", required = true) val language: LanguageEnum,

    @get:JsonProperty("startQuestion", required = true) val startQuestion: kotlin.String,

    @field:Valid
    @get:JsonProperty("inputType", required = true) val inputType: InputTypeEnum,

    @get:JsonProperty("story", required = true) val story: kotlin.String,

    @get:JsonProperty("averageScore", required = true) val averageScore: kotlin.Double,

    @get:JsonProperty("point", required = true) val point: kotlin.Int,

    @field:Valid
    @get:JsonProperty("studyStatus", required = true) val studyStatus: StudyStatusEnum,

    @get:JsonProperty("storyVoicePath") val storyVoicePath: kotlin.String? = null
    ) {

}

