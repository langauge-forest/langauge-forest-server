package language_forest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.cors.CorsConfigurationSource

@Configuration
class CorsConfig {

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val config = CorsConfiguration()
        config.allowedOrigins = listOf("http://localhost:3000", "http://localhost:8080", "http://172.30.1.12:3000") // 허용할 Origin 추가
        config.allowedMethods = listOf("GET", "POST", "PUT", "PATCH","DELETE", "OPTIONS") // 허용할 HTTP 메서드
        config.allowedHeaders = listOf("*") // 모든 헤더 허용
        config.allowCredentials = true // 쿠키 허용

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", config)
        return source
    }
}
