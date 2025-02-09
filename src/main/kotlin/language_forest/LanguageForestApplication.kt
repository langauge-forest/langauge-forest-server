package language_forest

import io.github.cdimascio.dotenv.Dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
class LanguageForestApplication


fun main(args: Array<String>) {
	// 🔥 현재 실행되는 환경 가져오기 (기본값: local)
	val activeProfile = System.getenv("SPRING_PROFILES_ACTIVE") ?: "local"

	// 🔥 해당 환경에 맞는 `.env` 파일 불러오기
	val dotenv = Dotenv.configure()
		.filename(".env.$activeProfile")  // `.env.local`, `.env.dev`, `.env.prod` 로 자동 선택
		.ignoreIfMissing()
		.load()

	// 🔥 `dotenv.entries()`를 사용하여 환경 변수 설정
	dotenv.entries().forEach { entry ->
		System.setProperty(entry.key, entry.value)
	}

	println("🚀 Loaded environment: $activeProfile")
	runApplication<LanguageForestApplication>(*args)
}