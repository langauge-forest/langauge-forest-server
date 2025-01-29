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

@Component
class OpenAiUtil(
    @Value("\${openai.api-key}") private val apiKey: String,
    @Value("\${openai.base-url}") private val apiUrl: String


) {
    fun generateSummary(inputText: String): String {
        val prompt = "너는 최고의 심리상담사 선생님이야. 1) 내가 오늘 하루를 이야기를 할거야. 2)너는 나의 하루를 들어주고 어떤 감정을 느꼈는지 분석해주고 이야기해줘. 3) 심플하게 한 문장으로만 이야기해줘. 4)다만 감정 단어를 선택할 때 너무 단순한 단어말고 조금 구체적이고 섬세한 단어들을 사용해줘 \\n\\n [출력 형식] 오늘은 xx한 하루를 보내셨군요 (여기서 xx는 기쁨, 슬픈, 화난, 등의 감정들)"
        return apiRequest(prompt, inputText)
    }

    fun generateMessage(inputText: String): String {
        val prompt = "너는 최고의 심리상담사 선생님이야. 1) 내가 오늘 하루를 이야기를 할거고, 너는 내 하루를 바탕으로 영어를 가르쳐주는 걸 할꺼야. 2)상담사처럼 따뜻하고 정중하게 이야기해줘. 무조건 긍정적인 것보다는 유저가 스스로 하루를 곱씹고 생각해볼 수 있게 좋은 질문을 던져주고, 마지막에는 긍정적인 공감을 해줘 4)150자 이하로 이야기해줘 5)인사는 생략해줘 [출력 형식] (하루를 간단히 요약하고 공감해주는 내용)"
        return apiRequest(prompt, inputText)
    }

    fun generateKeywords(inputText: String): String {
        val prompt = "너는 최고의 심리상담사 선생님이야. 1)내가 오늘 하루를 이야기할거야. 2) 너는 나의 하루를 들어주고 분석하여, 오늘 내가 느꼈던 감정이나 키워드들을 3-4개정도 도출해줘. 3)키워드는 최소 2글자, 최대 5글자로 해주. 4)키워드는 가능하면 내가 주로 사용했던 단어들을 선택해줘. 5)다만 키워드를 선택할 때 너무 단순한 단어 말고 조금 구체적이고 섬세한 단어들을 사용해줘, 고유명사가 나와도 좋아. 6) 단어마다 ','를 붙여줘\\n\\n [출력 형식]사랑, 힘듦, 헤어짐, 남자친구"
        return apiRequest(prompt, inputText)
    }

    fun generateEmoji(inputText: String): String {
        val prompt = "너는 이야기한 내용과 관련된 애플 이모지가 무엇인지 알려주는 로봇이야. 1) 내가 오늘 하루를 이야기를 할거야. 2)너는 나의 하루를 들어주고 3) 이와 관련된 애플 이모지를 답해줘. 4) 이모지는 1개만 말해야 해 \\n\\n [출력 형식] ☕️"
        return apiRequest(prompt, inputText)
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