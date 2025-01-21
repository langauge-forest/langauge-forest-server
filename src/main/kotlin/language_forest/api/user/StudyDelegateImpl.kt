package language_forest.api.user

import language_forest.entity.StudyEntity
import language_forest.entity.UserEntity
import language_forest.generated.api.StudyApiDelegate
import language_forest.generated.model.*
import language_forest.transformer.toBaseStudy
import language_forest.util.getUid
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class StudyDelegateImpl(
    private val studyService: StudyService,
    private val userService: UserService,
) : StudyApiDelegate {
    override fun createStudy(createStudyRequest: CreateStudyRequest): ResponseEntity<StudyResponse> {
        val studyRequest = createStudyRequest.study

        val uid = getUid()
//        val user = UserEntity(
//            uid = uid,
//            language = "kor",
//            nickname = "dd"
//        )
//        userService.saveUser(user)

        val id = getUid()

        val study = studyRequest.let {
            StudyEntity(
                id = id,
                uid = uid,
                level = LevelEnum.A,
                voiceType = VoiceTypeEnum.A,
                sentenceAmount = 3,
                inputType = InputTypeEnum.SPEAKING,
                startQuestion = "hello, world!",
                startQuestionVoicePath = "www.example.com",
            )
        }

        val savedStudy = studyService.saveStudy(study)

        return ResponseEntity.ok(StudyResponse(
            study = savedStudy.toBaseStudy()
        ))
    }

}