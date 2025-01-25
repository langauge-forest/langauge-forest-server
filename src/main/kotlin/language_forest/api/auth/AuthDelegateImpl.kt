package language_forest.api.auth


import language_forest.entity.UserEntity
import language_forest.exception.UnauthorizedException
import language_forest.generated.api.AuthApiDelegate
import language_forest.generated.model.AuthRefreshRequest
import language_forest.generated.model.GoogleLoginRequest
import language_forest.generated.model.TokenDto
import language_forest.transformer.toLanguageEnum
import language_forest.util.JwtUtil
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class AuthDelegateImpl(
    private val authGoogleService: AuthGoogleService,
    private val jwtUtil: JwtUtil,
    private val authService: AuthService
) : AuthApiDelegate {
    override fun googleLogin(googleLoginRequest: GoogleLoginRequest): ResponseEntity<TokenDto> {
        val googleToken = googleLoginRequest.token.accessToken

        val googleOAuth = authGoogleService.getUserInfo(googleToken)
        val user = authService.googleLogin(googleOAuth, googleLoginRequest.language.toLanguageEnum())

        val accessToken = jwtUtil.generateToken(user.uid)
        val refreshToken = jwtUtil.generateRefreshToken(user.uid)

        return ResponseEntity.ok(TokenDto(accessToken, refreshToken))
    }

    override fun authRefresh(authRefreshRequest: AuthRefreshRequest): ResponseEntity<TokenDto> {
        val refreshToken = authRefreshRequest.refreshToken
        val isValidatedRefreshToken = jwtUtil.validateRefreshToken(refreshToken)
        if (!isValidatedRefreshToken){
            throw UnauthorizedException("invalid refresh token")
        }

        val uid = jwtUtil.getAuthUid(refreshToken)

        // 새 AccessToken 발급
        val newAccessToken = jwtUtil.generateToken(uid)
        val newRefreshToken = jwtUtil.generateRefreshToken(uid)

        return ResponseEntity.ok(TokenDto(newAccessToken,newRefreshToken))
    }
}


