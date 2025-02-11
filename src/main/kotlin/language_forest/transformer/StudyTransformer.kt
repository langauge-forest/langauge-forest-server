package language_forest.transformer

import language_forest.entity.StudyEntity
import language_forest.entity.StudyPracticeEntity
import language_forest.entity.StudySummaryEntity
import language_forest.entity.UserStudyInfoEntity
import language_forest.generated.model.*
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
        studyStatus = StudyStatusEnum.PENDING,
        point = 0
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

fun StudyEntity.toBaseStudy(): BaseStudy {
    return BaseStudy(
        id = this.id,
        uid = this.uid,
        userStudyInfoId = this.userStudyInfoId,
        voiceType = this.voiceType,
        level = this.level,
        sentenceAmount = this.sentenceAmount,
        language = this.language,
        startQuestion = startQuestion,
        inputType = this.inputType,
        story = this.story,
        storyVoicePath = this.storyVoicePath,
        averageScore = this.averageScore?: 0.0,
        studyStatus = this.studyStatus,
        point = this.point
    )
}

fun StudySummaryEntity.toBaseStudySummary(): BaseStudySummary {
    return BaseStudySummary(
        id = this.id,
        studyId = this.studyId,
        summary = this.summary,
        message = this.message,
        emoji = this.emoji,
        tags = this.tags?: listOf(),
        selectedTag = this.selectedTag?: ""
    )
}

fun StudyPracticeEntity.toBaseStudyPractice(): BaseStudyPractice {
    return BaseStudyPractice(
        id = this.id,
        studyId = this.studyId,
        problemNumber = this.problemNumber,
        problem = this.problem,
        correctAnswer = this.correctAnswer?: "",
        myAnswer = this.myAnswer?: "",
        myAnswerVoicePath = this.myAnswerVoicePath,
        tip = this.tip?: "",
        score = this.score?: 0
    )
}