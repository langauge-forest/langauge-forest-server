package language_forest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.util.*

@SpringBootApplication
@EnableJpaAuditing
class LanguageForestApplication

fun main(args: Array<String>) {
	runApplication<LanguageForestApplication>(*args)
}
