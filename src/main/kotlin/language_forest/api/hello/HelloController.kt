package language_forest.api.hello

import language_forest.generated.api.HelloApi
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(
    private val helloService: HelloService
) : HelloApi {

    override fun getHello(): ResponseEntity<String>? {
        val greeting = helloService.getGreeting()
        return ResponseEntity.ok(greeting)
    }
}