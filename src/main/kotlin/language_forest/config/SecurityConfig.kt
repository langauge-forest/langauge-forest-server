package language_forest.config

import language_forest.filter.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter
) {
    // /auth/** 경로 전용 필터 체인 (필터 제외)
    @Bean
    fun authFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .securityMatcher("/auth/**") // /auth/** 경로만 처리
            .authorizeHttpRequests { authz ->
                authz.anyRequest().permitAll() // 인증 불필요
            }
            .csrf { csrf -> csrf.disable() }
            .build()
    }

    // 나머지 요청 전용 필터 체인
    @Bean
    fun apiFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .securityMatcher("/**") // 모든 경로
            .authorizeHttpRequests { authz ->
                authz.anyRequest().authenticated() // 인증 필요
            }
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java) // 필터 추가
            .sessionManagement { sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .csrf { csrf -> csrf.disable() }
            .build()
    }

}