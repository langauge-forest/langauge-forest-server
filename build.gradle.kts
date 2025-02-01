plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("plugin.jpa") version "1.9.25"
	id("org.openapi.generator") version "7.10.0"
	id("com.google.cloud.tools.jib") version "3.4.4"
	id("org.flywaydb.flyway") version "11.3.0"
}

group = "language-forest"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

springBoot {
	mainClass = "language_forest.LanguageForestApplicationKt"
}

val projectVersion = project.version.toString()
val ecrImage = System.getenv("ECR_IMAGE") ?: "11t518s/language-forest"
val imageTag = System.getenv("IMAGE_TAG") ?: projectVersion // 환경변수 없으면 기본값

jib {
	from {
		image = "amazoncorretto:21-alpine"
	}
	to {
		image = ecrImage
		tags = setOf(imageTag) // IMAGE_TAG를 사용
	}
	container {
		ports = listOf("8080")
		jvmFlags = listOf("-Xms512m", "-Xmx1024m")
		mainClass = "language_forest.LanguageForestApplicationKt"
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
	// Spring Boot Dependencies
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("io.jsonwebtoken:jjwt-api:0.12.6")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")
	implementation("org.flywaydb:flyway-core:11.3.0")
	implementation("org.flywaydb:flyway-mysql:11.3.0")
	implementation("com.mysql:mysql-connector-j:8.4.0")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.9.0")

	implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")  // .env 파일 로드 라이브러리

	// Jackson Nullable
	implementation("org.openapitools:jackson-databind-nullable:0.2.4")

	implementation("com.vladmihalcea:hibernate-types-60:2.21.1")

	// Validation
	implementation("jakarta.validation:jakarta.validation-api:3.0.2")
	implementation("org.hibernate.validator:hibernate-validator:8.0.0.Final")

	// JUnit
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.flywaydb:flyway-mysql:11.3.0")
	}
}


val envName: String? by project
val envFile = file(".env.${envName ?: "local"}") // 🔥 루트에서 로드!

fun loadEnv(file: File): Map<String, String> {
	if (!file.exists()) {
		println("⚠️ ${file.name} 파일이 존재하지 않습니다. 기본값(local) 사용")
		return emptyMap()
	}

	return file.readLines()
		.filter { it.contains("=") && !it.startsWith("#") }
		.map {
			val (key, value) = it.split("=", limit = 2)
			key.trim() to value.trim()
		}.toMap()
}

val envVars = loadEnv(envFile)


flyway {
	driver = "com.mysql.cj.jdbc.Driver"

	url = envVars["DB_URL"] ?: "jdbc:mysql://localhost:3306/db"
	user = envVars["DB_USERNAME"] ?: "mysql"
	password = envVars["DB_PASSWORD"] ?: "mysql"

	locations = arrayOf("filesystem:src/main/resources/db/migration")

	println("🚀 Flyway Migration 실행: ${envName ?: "local"} 환경")
}

// OpenAPI Generator 설정
openApiGenerate {
	inputSpec.set("$rootDir/language-forest-api/api.yml") // 여기서 스펙 파일 경로 지정
	generatorName.set("kotlin-spring") // Kotlin 전용 생성기 사용
	outputDir.set("$rootDir/generated-language-forest-api") // build 외부 디렉토리로 변경
	apiPackage.set("language_forest.generated.api")
	modelPackage.set("language_forest.generated.model")
	invokerPackage.set("language_forest.generated.invoker")


	configOptions.put("useKotlin", "true") // Kotlin 모델 활성화
	configOptions.put("library", "spring-boot")
	configOptions.set(mapOf("useSpringBoot3" to "true"))
	configOptions.put("documentationProvider", "none") // Swagger 및 SpringDoc 제거
	configOptions.put("delegatePattern", "true") // Delegate 패턴 활성화

	typeMappings.set(mapOf("OffsetDateTime" to "LocalDateTime"))
//	configOptions.put("interfaceOnly", "true") // 인터페이스만 생성, 컨트롤러 생성 X
}

tasks.register("buildApi") {
	dependsOn("openApiGenerate")
	doLast {
		println("API 코드가 생성되었습니다.")
	}
}

sourceSets {
	main {
		kotlin {
			srcDir("$rootDir/generated-language-forest-api")
		}
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
