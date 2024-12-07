package language_forest.api.hello

import org.springframework.stereotype.Service

@Service
class HelloService {
    fun getGreeting(): String {
        return "hello with open api generator"
    }
}