plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("plugin.jpa") version "1.9.25"
	id("org.openapi.generator") version "7.10.0"
}

group = "language-forest"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
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
	implementation("org.flywaydb:flyway-mysql")

	implementation("io.jsonwebtoken:jjwt-api:0.12.6")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.6")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.6")
	runtimeOnly("com.mysql:mysql-connector-j")

	// Jackson Nullable
	implementation("org.openapitools:jackson-databind-nullable:0.2.4")

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


// OpenAPI Generator 설정
openApiGenerate {
	inputSpec.set("$rootDir/src/main/resources/api.yml") // 여기서 스펙 파일 경로 지정
	generatorName.set("spring") // spring 서버 스텁 생성
	outputDir.set(layout.buildDirectory.dir("generated").get().asFile.absolutePath)
	apiPackage.set("language_forest.generated.api")
	modelPackage.set("language_forest.generated.model")
	invokerPackage.set("language_forest.generated.invoker")

	configOptions.put("documentationProvider", "none") // Swagger 및 SpringDoc 제거
	configOptions.put("delegatePattern", "true") // Delegate 패턴 활성화
	configOptions.put("interfaceOnly", "true") // 인터페이스만 생성, 컨트롤러 생성 X
}

tasks.named("openApiGenerate") {
	doLast {
		// 생성된 ApiUtil.java 파일 강제 삭제
		file("$buildDir/generated/src/main/java/language_forest/generated/api/ApiUtil.java").delete()
		fileTree(layout.buildDirectory.dir("generated")).forEach { file ->
			if (file.name.endsWith(".java")) {
				file.writeText(
					file.readText()
						.replace("javax", "jakarta")
				)
			}
		}
	}
}

tasks.register("buildApi") {
	dependsOn("openApiGenerate")
	doLast {
		println("API 코드가 생성되었습니다.")
	}
}

sourceSets {
	main {
		java {
			srcDir(layout.buildDirectory.dir("generated/src/main/java"))
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
