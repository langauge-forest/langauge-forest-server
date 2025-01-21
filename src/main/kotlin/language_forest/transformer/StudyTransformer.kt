package language_forest.transformer

import language_forest.entity.StudyEntity
import language_forest.generated.model.BaseStudy

fun StudyEntity.toBaseStudy(): BaseStudy {
    return BaseStudy(
        id = this.id,
        uid = this.uid,
        level = this.level,
        voiceType = this.voiceType,
        sentenceAmount = this.sentenceAmount
    )
}