package language_forest.api.auth


import language_forest.generated.api.AuthApiDelegate
import language_forest.generated.model.TokenDto
import language_forest.util.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class AuthDelegateImpl(
    private val authGoogleService: AuthGoogleService,
    private val jwtUtil: JwtUtil,
    private val authService: AuthService
) : AuthApiDelegate {
    override fun googleLogin(tokenDto: TokenDto): ResponseEntity<TokenDto> {
        val googleToken = tokenDto.accessToken

        val googleOAuth = authGoogleService.getUserInfo(googleToken)
        val user = authService.googleLogin(googleOAuth)

        val jwt = jwtUtil.generateToken(user)

        return ResponseEntity.ok(TokenDto(jwt))
    }
}


