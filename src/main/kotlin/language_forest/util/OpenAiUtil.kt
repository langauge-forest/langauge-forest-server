package language_forest.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.coroutines.*

@Component
class OpenAiUtil(
    @Value("\${openai.api-key}") private val apiKey: String,
    @Value("\${openai.base-url}") private val apiUrl: String


) {
    suspend fun generateSummary(inputText: String): String {
        val prompt = "너는 최고의 심리상담사 선생님이야. 1) 내가 오늘 하루를 이야기를 할거야. 2)너는 나의 하루를 들어주고 어떤 감정을 느꼈는지 분석해주고 이야기해줘. 3) 심플하게 한 문장으로만 이야기해줘. 4)다만 감정 단어를 선택할 때 너무 단순한 단어말고 조금 구체적이고 섬세한 단어들을 사용해줘 \\n" +
                "\\n" +
                "[출력 형식] \\n" +
                "오늘은 xx한 하루를 보내셨군요 (여기서 xx는 기쁨, 슬픈, 화난, 등의 감정들)"
        return apiRequest(prompt, inputText)
    }

    suspend fun generateMessage(inputText: String): String {
        val prompt = "너는 최고의 심리상담사 선생님이야. 1) 내가 오늘 하루를 이야기를 할거고, 너는 내 하루를 바탕으로 영어를 가르쳐주는 걸 할꺼야. 2)상담사처럼 따뜻하고 정중하게 이야기해줘. 무조건 긍정적인 것보다는 유저가 스스로 하루를 곱씹고 생각해볼 수 있게 좋은 질문을 던져주고, 마지막에는 긍정적인 공감을 해줘 4)150자 이하로 이야기해줘 5)인사는 생략해줘 \\n" +
                "\\n" +
                "[출력 형식] \\n" +
                "(하루를 간단히 요약하고 공감해주는 내용)"
        return apiRequest(prompt, inputText)
    }

    suspend fun generateTags(inputText: String): String {
        val prompt = "너는 최고의 심리상담사 선생님이야. 1)내가 오늘 하루를 이야기할거야. 2) 너는 나의 하루를 들어주고 분석하여, 오늘 내가 느꼈던 감정이나 키워드들을 3-4개정도 도출해줘. 3)키워드는 최소 2글자, 최대 5글자로 해주. 4)키워드는 가능하면 내가 주로 사용했던 단어들을 선택해줘. 5)다만 키워드를 선택할 때 너무 단순한 단어 말고 조금 구체적이고 섬세한 단어들을 사용해줘, 고유명사가 나와도 좋아. 6) 단어마다 ','를 붙여줘 \\n" +
                "\\n" +
                "[출력 형식] \\n" +
                "사랑, 힘듦, 헤어짐, 남자친구"
        return apiRequest(prompt, inputText)
    }

    suspend fun generateEmoji(inputText: String): String {
        val prompt = "너는 이야기한 내용과 관련된 애플 이모지가 무엇인지 알려주는 로봇이야. 1) 내가 오늘 하루를 이야기를 할거야. 2)너는 나의 하루를 들어주고 3) 이와 관련된 애플 이모지를 답해줘. 4) 이모지는 1개만 말해야 해 \\n" +
                "\\n" +
                "[출력 형식] \\n" +
                "☕️"
        return apiRequest(prompt, inputText)
    }

    suspend fun generateSummaryContents(story: String): Triple<String, String, Pair<String, String>> = coroutineScope {

        val summaryDeferred = async { generateSummary(story) }
        val messageDeferred = async { generateMessage(story) }
        val tagsDeferred = async { generateTags(story) }
        val emojiDeferred = async { generateEmoji(story) }

        val summary = summaryDeferred.await()
        val message = messageDeferred.await()
        val tags = tagsDeferred.await()
        val emoji = emojiDeferred.await()

        return@coroutineScope Triple(summary, message, Pair(tags, emoji))
    }


    fun generateProblems(inputText: String, sentenceAmount: String, userLanguage: String, studyLanguage: String, level: String): String {
        val prompt = "[역할]\\n" +
                "너는 유저의 하루데이터를 입력받아서, ${userLanguage} 문장 ${sentenceAmount}문장을 만들어주는 문제출제자야. \\n" +
                "유저는 오늘 자신의 하루데이터(일기)를 바탕으로 ${studyLanguage} 공부를 할 예정이고, \\n" +
                "나의 하루를 남에게 설명하는 연습을 할 거고, 당연히 1인칭 시점으로 서술해줘. \\n" +
                "\\n" +
                "[조건] \\n" +
                "1) 입력된 데이터를 바탕으로 오늘 하루를 요약하는 ${userLanguage} 문장 ${sentenceAmount}문장으로 만들어줘. 문장은 맥락이 연결되고 주어, 동사가 있으며 문법적으로 완성되어야 해. \\n" +
                "(존댓말말고 반말로 써줘.) \\n" +
                "2) ${userLanguage} 문장만 나와야 하고, 각 문장은 엔터로만 구분해줘. \\n" +
                "3) 문장의 길이는 ${level} 내외로 해주고, 문장 마지막에는 항상 마침표(.)를 찍어줘. \\n" +
                "\\n" +
                "[출력예시] \\n" +
                "... \\n" +
                "(${userLanguage} 문장${sentenceAmount})"
        return apiRequest(prompt, inputText)
    }

    fun generateAnswer(studyLanguage: String, userLanguage: String, myAnswer: String, problem: String): String {
        val prompt = "[역할] \\n" +
                "너는 ${studyLanguage} 문화권에서 30년 이상 살아온 원어민이야. \\n" +
                "너는 ${userLanguage}를 모국어로 사용하는 학생에게 ${studyLanguage} 문화와 언어를 가르치는 선생님이야. \\n" +
                "학생이 입력한 ${studyLanguage} 원문을 바탕으로 자연스럽고 세련된 원어민 표현으로 교정해줄 거야. \\n" +
                "\\n" +
                "[조건] \\n" +
                "1) 원문을 ${studyLanguage} 원어민이 자연스럽게 쓸 법한 표현으로 부드럽고 세련되게 수정해줘. (입력한 원문의 뉘앙스를 최대한 살려서) \\n" +
                "2) 학생이 의도한 ${userLanguage} 표현: ${problem} \\n" +
                "3) 교정된 ${studyLanguage} 문장만 출력해줘."
        return apiRequest(prompt, myAnswer)
    }

    suspend fun generateScore(studyLanguage: String, userLanguage: String, myAnswer: String, correctAnswer: String): Int {
        val prompt = "[상황] \\n" +
                "너는 ${studyLanguage} 문화권에서 30년 이상 살아온 원어민이야. \\n" +
                "너는 ${userLanguage}를 모국어로 사용하는 학생에게 ${studyLanguage} 문화와 언어를 가르치는 선생님이야. \\n" +
                "학생이 입력한 ${studyLanguage} 원문을 바탕으로 100점 만점으로 채점을 해줄거야. \\n" +
                "\\n" +
                "[조건] \\n" +
                "1) 정답은 ${studyLanguage} 문장으로 '${correctAnswer}'이야. 학생이 입력한 ${studyLanguage} 문장과 비교해줘 \\n" +
                "2) 100점 만점에 n점으로 평가해줘. \\n" +
                "3) 다른 미사여구 넣지 말고 'n' 숫자만 출력해줘 \\n" +
                "4) 텍스트가 달라도 뜻이 일치하면 맞다고 처리해줘 (ex. 어순이 다르지만 의미가 같다면 정답으로 인정) \\n" +
                "\\n" +
                "[출력 예시] \\n" +
                "n"
        return apiRequest(prompt, myAnswer).toInt()
    }

    suspend fun generateTip(studyLanguage: String, userLanguage: String, myAnswer: String, correctAnswer: String): String {
        val prompt = "[상황] \\n" +
                "너는 ${studyLanguage} 문화권에서 30년 이상 살아온 원어민이야. \\n" +
                "너는 ${userLanguage}를 모국어로 사용하는 학생에게 ${studyLanguage} 문화와 언어를 가르치는 선생님이야. \\n" +
                "학생이 입력한 ${studyLanguage} 원문을 바탕으로 피드백을 교정해줄 거야. \\n" +
                "\\n" +
                "[조건] \\n" +
                "1) 정답은 ${studyLanguage} 문장으로 '${correctAnswer}' 이야. 학생이 입력한 ${studyLanguage} 문장과 비교해줘. \\n" +
                "2) 학생이 입력한 ${studyLanguage} 문장을 '${correctAnswer}'로 고치려면 어떻게 하면 좋을지 피드백을 제공해줘. \\n" +
                "3) 피드백은 최대 3개로, 상세하게 이야기하되 높임말로 쉽게 풀어서 각각 150자 이내로 작성해줘. \\n" +
                "4) 텍스트가 달라도 뜻이 일치하면 특별히 피드백하지 않아도 되고, 대소문자는 무시해도 돼 \\n" +
                "5) 피드백은 ${userLanguage} 문장으로 제공해줘. \\n" +
                "\\n" +
                "[출력 예시] \\n" +
                "(1) \\n" +
                "피드백 상세 내용 (in ${userLanguage}) \\n" +
                "\\n" +
                "(2) \\n" +
                "피드백 상세 내용 (in ${userLanguage}) \\n" +
                "\\n" +
                "(3) \\n" +
                "피드백 상세 내용 (in ${userLanguage})"
            return apiRequest(prompt, myAnswer)
    }

    suspend fun generateScoreAndTip(studyLanguage: String, userLanguage: String, myAnswer: String, correctAnswer: String): Pair<Int, String> = coroutineScope {
        val scoreDeferred = async { generateScore(studyLanguage, userLanguage, myAnswer, correctAnswer) }
        val tipDeferred = async { generateTip(studyLanguage, userLanguage, myAnswer, correctAnswer) }

        val score = scoreDeferred.await()
        val tip = tipDeferred.await()

        return@coroutineScope Pair(score, tip)
    }

    private fun apiRequest(prompt: String, inputText: String): String {
        val headers = HttpHeaders().apply {
            set("Content-Type", "application/json")
            set("Authorization", "Bearer $apiKey")
        }
        val requestBody = getRequestBody(prompt, inputText)
        val entity = HttpEntity(requestBody, headers)
        val restTemplate = RestTemplate()

        val jsonString: String = try {
            val response: ResponseEntity<String> = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String::class.java)
            response.body ?: "{}" // 기본값 "{}" 설정
        } catch (ex: Exception) {
            ex.printStackTrace()
            "{}" // 예외 발생 시 빈 JSON 객체 반환
        }

        @Serializable
        data class Message(val content: String)

        @Serializable
        data class Choice(val message: Message)

        @Serializable
        data class ApiResponse(val choices: List<Choice>)

        val json = Json { ignoreUnknownKeys = true }
        val response = json.decodeFromString<ApiResponse>(jsonString)
        return response.choices[0].message.content
    }

    private fun getRequestBody(prompt: String, inputText: String): String {
        return """
            {
              "model": "gpt-4o",
              "messages": [
                {
                  "role": "system",
                  "content": "${prompt}"
                },
                {
                  "role": "user",
                  "content": [
                    {
                      "type": "text",
                      "text": "${inputText}"
                    }
                  ]
                }
              ],
              "temperature": 1,
              "max_tokens": 256,
              "top_p": 1,
              "frequency_penalty": 0,
              "presence_penalty": 0,
              "response_format": {
                "type": "text"
              }
            }
        """.trimIndent()
    }
}