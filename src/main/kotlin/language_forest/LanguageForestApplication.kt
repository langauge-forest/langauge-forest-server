package language_forest

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication

@SpringBootApplication
class LanguageForestApplication

fun main(args: Array<String>) {
	val context = SpringApplicationBuilder(LanguageForestApplication::class.java)
		.web(WebApplicationType.SERVLET)
		.run()

	// ApplicationContext의 모든 Bean 이름 출력
	val beanNames = context.beanDefinitionNames
	beanNames.filter { it.contains("hello", ignoreCase = true) }.forEach {
		println("Bean: $it, Type: ${context.getBean(it)::class.java.name}")
	}

//	runApplication<LanguageForestApplication>(*args)
}
