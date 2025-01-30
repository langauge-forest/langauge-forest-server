package language_forest.transformer

import language_forest.entity.StudyEntity
import language_forest.entity.StudyPracticeEntity
import language_forest.entity.UserStudyInfoEntity
import language_forest.generated.model.CreateStudy
import language_forest.generated.model.CreateStudyPracticeResponseStudyPracticesInner
import language_forest.generated.model.StudyStatusEnum
import language_forest.generated.model.UpdateStudyPracticeResponseStudyPractice
import java.util.*

fun CreateStudy.toStudyEntity(id: UUID, uid: UUID, userStudyInfo: UserStudyInfoEntity): StudyEntity {
    return StudyEntity(
        id = id,
        uid = uid,
        userStudyInfoId = this.userStudyInfoId,
        voiceType = userStudyInfo.voiceType,
        level = userStudyInfo.level,
        sentenceAmount = userStudyInfo.sentenceAmount,
        language = userStudyInfo.language,
        startQuestion = this.startQuestion,
        inputType = this.inputType,
        story = this.story,
        storyVoicePath = this.storyVoicePath,
        averageScore = 0.0,
        studyStatusEnum = StudyStatusEnum.PENDING
    )
}

fun StudyPracticeEntity.toCreateStudyPracticeResponseStudyPracticesInner(): CreateStudyPracticeResponseStudyPracticesInner {
    return CreateStudyPracticeResponseStudyPracticesInner(
        studyPracticeId = this.id,
        problemNumber = this.problemNumber,
        problem = this.problem
    )
}

fun StudyPracticeEntity.toUpdateStudyPracticeResponseStudyPractice(): UpdateStudyPracticeResponseStudyPractice {
    return UpdateStudyPracticeResponseStudyPractice(
        problemNumber = this.problemNumber,
        problem = this.problem,
        myAnswer = this.myAnswer,
        myAnswerVoicePath = myAnswerVoicePath,
        correctAnswer = this.correctAnswer,
        score = this.score,
        tip = this.tip
    )
}