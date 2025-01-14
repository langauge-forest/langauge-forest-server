package language_forest.util

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import language_forest.entity.UserEntity
import language_forest.exception.UnauthorizedException
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*
import javax.crypto.SecretKey

@Component
class JwtUtil {
    private val secretKey: SecretKey = Keys.hmacShaKeyFor("test-auth-key-test-auth-key-test-auth-key".toByteArray()) // 256비트 키

    private val accessTokenSubject = "accessToken"
    private val accessTokenExpirationDays: Long = 1
    private val refreshTokenSubject = "refreshToken"
    private val refreshTokenExpirationDays: Long = 14

    /**
     * JWT 토큰 생성
     */
    fun generateToken(user: UserEntity): String {
        val claims: Claims = Jwts.claims()
            .add("uid", user.uid.toString())
            .build()

        val now = Instant.now()

        return Jwts.builder()
            .subject(accessTokenSubject)
            .issuedAt(Date.from(now))
            .expiration(Date.from(now.plus(accessTokenExpirationDays, ChronoUnit.DAYS)))
            .claims(claims)
            .signWith(secretKey)
            .compact()
    }

    /**
     * JWT 토큰 생성 - RefreshToken 추가
     */
    fun generateRefreshToken(user: UserEntity): String {
        val claims: Claims = Jwts.claims()
            .add("uid", user.uid.toString())
            .build()

        val now = Instant.now()

        return Jwts.builder()
            .subject(refreshTokenSubject)
            .issuedAt(Date.from(now))
            .expiration(Date.from(now.plus(refreshTokenExpirationDays, ChronoUnit.DAYS))) // RefreshToken은 7일로 설정
            .claims(claims)
            .signWith(secretKey)
            .compact()
    }

    /**
     * JWT 토큰 검증
     */
    fun validateToken(token: String): Boolean {
        try {
            val claim = getClaims(token)
            return claim.subject == accessTokenSubject
        } catch (e: Exception) {
            when (e) {
                is io.jsonwebtoken.ExpiredJwtException -> throw UnauthorizedException("expired access token")
                is io.jsonwebtoken.JwtException -> throw UnauthorizedException("Invalid access token")
                else -> throw UnauthorizedException("Unexpected refresh token error: ${e.message}")
            }
        }
    }

    /**
     * Refresh Token 검증
     */
    fun validateRefreshToken(token: String): Boolean {
        try {
            val claims = getClaims(token)
            // 토큰이 refresh 토큰인지 확인
            // 우선 크게 중요할 것 같진 않아서 subject만 확인해보는것으로 한다, 후에 redis에서 검증하거나 뭐... 하는걸루
            return claims.subject == refreshTokenSubject
        } catch (e: Exception) {
            when (e) {
                is io.jsonwebtoken.ExpiredJwtException -> throw UnauthorizedException("expired refresh token")
                is io.jsonwebtoken.JwtException -> throw UnauthorizedException("Invalid refresh token")
                else -> throw UnauthorizedException("Unexpected refresh token error: ${e.message}")
            }
        }
    }

    fun getAuthUid(token: String): UUID {
        val claims: Claims = getClaims(token)
        val uidString = claims.get("uid", String::class.java)?: throw UnauthorizedException("no uid field")
        return UUID.fromString(uidString)
    }

    private fun getClaims(token: String): Claims {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .payload
    }
}
