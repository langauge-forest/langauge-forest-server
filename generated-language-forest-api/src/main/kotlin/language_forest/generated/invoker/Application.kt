package language_forest.generated.invoker

import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["language_forest.generated.invoker", "language_forest.generated.api", "language_forest.generated.model"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
