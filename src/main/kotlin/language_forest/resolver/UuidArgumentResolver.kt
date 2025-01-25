package language_forest.resolver

import language_forest.exception.BadRequestException
import language_forest.exception.UnauthorizedException
import org.springframework.core.MethodParameter
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import java.util.UUID

@Component
class UuidArgumentResolver : HandlerMethodArgumentResolver {
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(AuthenticationPrincipal::class.java) &&
                parameter.parameterType == UUID::class.java
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: org.springframework.web.context.request.NativeWebRequest,
        binderFactory: org.springframework.web.bind.support.WebDataBinderFactory?
    ): Any? {
        val authentication = SecurityContextHolder.getContext().authentication

        if (authentication == null || authentication.name.isNullOrBlank()) {
            // SecurityContext가 비어 있는 경우 처리
            throw UnauthorizedException("User is not authenticated")
        }

        return try {
            UUID.fromString(authentication.name)
        } catch (ex: IllegalArgumentException) {
            throw BadRequestException("Invalid user identifier")
        }
    }
}
