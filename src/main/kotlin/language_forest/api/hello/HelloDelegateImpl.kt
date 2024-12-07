package language_forest.api.hello

import language_forest.generated.api.HelloApi
import language_forest.generated.api.HelloApiDelegate
import language_forest.generated.model.YourTextDto
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class HelloDelegateImpl(
    private val helloService: HelloService
) : HelloApiDelegate {
    override fun getHello(): ResponseEntity<String> {
        return ResponseEntity.ok(helloService.getGreeting())
    }

    override fun getHelloJson(text: String): ResponseEntity<YourTextDto> {
        return ResponseEntity.ok(YourTextDto(yourText = text))
    }
}