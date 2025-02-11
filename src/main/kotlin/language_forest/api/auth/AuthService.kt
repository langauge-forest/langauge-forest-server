package language_forest.api.auth

import language_forest.api.auth.dto.GoogleOAuth
import language_forest.entity.AppleUserInfoEntity
import language_forest.entity.GoogleUserInfoEntity
import language_forest.entity.UserEntity
import language_forest.generated.model.AppleLoginRequest
import language_forest.generated.model.LanguageEnum
import language_forest.repository.AppleUserInfoRepository
import language_forest.repository.GoogleUserInfoRepository
import language_forest.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class AuthService(
    private val userRepository: UserRepository,
    private val googleUserInfoRepository: GoogleUserInfoRepository,
    private val appleUserInfoRepository: AppleUserInfoRepository
) {
    @Transactional
    fun appleLogin(appleUserInfo: AppleLoginRequest, language: LanguageEnum): UserEntity {
        val savedAppleUser = appleUserInfoRepository.findByAppleId(appleUserInfo.appleId)
        if (savedAppleUser == null) {
            // 유저 정보가 없을 경우 새로 생성
            val nickname = appleUserInfo.nickname
                    ?: listOfNotNull(
                        appleUserInfo.namePrefix,
                        appleUserInfo.givenName,
                        appleUserInfo.middleName,
                        appleUserInfo.familyName,
                        appleUserInfo.nameSuffix
                    ).joinToString(" ")
                    ?: "user"
            val uid = UUID.randomUUID()
            val newUser = UserEntity(
                uid = uid,
                language = language,
                nickname = nickname,
                profileImage = null
            )

            try {
                val savedUser = userRepository.save(newUser)

                appleUserInfoRepository.save(AppleUserInfoEntity(
                    uid = savedUser.uid,
                    appleId = appleUserInfo.appleId,
                    email = appleUserInfo.email,
                    familyName = appleUserInfo.familyName,
                    givenName = appleUserInfo.givenName,
                    middleName = appleUserInfo.middleName,
                    namePrefix = appleUserInfo.namePrefix,
                    nameSuffix = appleUserInfo.nameSuffix,
                    nickname = appleUserInfo.nickname,
                    nonce = appleUserInfo.nonce,
                    realUserStatus = appleUserInfo.realUserStatus,
                    state = appleUserInfo.state,
                ))

                return newUser
            } catch (e: Exception) {
                throw Exception(e)
            }
        } else {
            return userRepository.findByIdOrNull(savedAppleUser.uid)
                ?: throw IllegalStateException("User not found for UID: ${savedAppleUser.uid}")
        }
    }


    @Transactional
    fun googleLogin(googleOAuth: GoogleOAuth, language: LanguageEnum): UserEntity {
        val googleId = googleOAuth.sub
        val googleUserInfo = googleUserInfoRepository.findByGoogleId(googleId)
        if (googleUserInfo == null) {
            // 유저 정보가 없을 경우 새로 생성
            val uid = UUID.randomUUID()
            val newUser = UserEntity(
                uid = uid,
                language = language,
                nickname = googleOAuth.name ?: "",
                profileImage = googleOAuth.picture
            )

            try {
                val savedUser = userRepository.save(newUser) // 저장 후 반환된 엔티티에서 ID 확인

                // Google 사용자 정보 저장
                val googleInfo = GoogleUserInfoEntity(
                    uid = savedUser.uid,
                    googleId = googleOAuth.sub,
                    email = googleOAuth.email,
                    name = googleOAuth.name,
                    picture = googleOAuth.picture,
                    locale = googleOAuth.locale,
                )
                googleUserInfoRepository.save(googleInfo)

                return newUser
            } catch (e: Exception) {
                throw Exception(e)
            }
        } else {
            return userRepository.findByIdOrNull(googleUserInfo.uid)
                ?: throw IllegalStateException("User not found for UID: ${googleUserInfo.uid}")
        }
    }

    @Transactional
    fun dummyLogin(): UserEntity {
        return userRepository.findByNickname("dummy")
//            ?: throw IllegalStateException("User not found for nickname: dummy")
    }
}