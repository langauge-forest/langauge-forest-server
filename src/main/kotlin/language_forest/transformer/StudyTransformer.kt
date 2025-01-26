package language_forest.transformer

import language_forest.entity.StudyEntity
import language_forest.generated.model.*
import java.util.*

fun StudyEntity.toBaseStudy(): BaseStudy {
    return BaseStudy(
        id = this.id,
        uid = this.uid,
        level = this.level,
        voiceType = this.voiceType,
        sentenceAmount = this.sentenceAmount,
        inputType = this.inputType,
        startQuestion = this.startQuestion,
        startQuestionVoicePath = this.startQuestionVoicePath
    )
}

fun CreateStudyRequestStudy.toStudyEntity(id: UUID, uid: UUID): StudyEntity {
    return StudyEntity(
        id = id,
        uid = uid,
        level = this.level?: LevelEnum.A,
        voiceType = this.voiceType?: VoiceTypeEnum.A,
        sentenceAmount = this.sentenceAmount?: 3,
        inputType = this.inputType?: InputTypeEnum.SPEAKING,
        startQuestion = "hello",
        startQuestionVoicePath = "www.example.com"
    )
}