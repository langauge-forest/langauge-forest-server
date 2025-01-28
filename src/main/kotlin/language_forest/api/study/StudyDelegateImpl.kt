package language_forest.api.study

import language_forest.generated.api.StudyApiDelegate
import language_forest.generated.model.*
import language_forest.transformer.*
import language_forest.util.OpenAiUtil
import language_forest.util.getUid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class StudyDelegateImpl(
    private val studyService: StudyService,
    private val openAiUtil: OpenAiUtil
) : StudyApiDelegate {
    override fun createStudy(createStudyRequest: CreateStudyRequest): ResponseEntity<StudyResponse> {
        val uid = getUid()
        val id = UUID.randomUUID()
        val studyRequest = createStudyRequest
            .study
            .toStudyEntity(
                uid = uid,
                id = id
            )
        studyService.saveStudy(studyRequest)

        println(openAiUtil.generateSummary("오늘 학교 친구들과 함께 치킨을 먹었어 치킨을 먹으면서 새해에 어떤 일들을 할 계획인지 이야기 나눴어 그 다음에 우리가 같이 하기로 했던 프로젝트에 관해서 이야기를 나누고 그 계획을 함께 계획했어\\n"))

        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}