package language_forest.api.userInfo

import language_forest.generated.api.UserInfoApiDelegate
import language_forest.generated.model.CreateUserInfoRequest
import language_forest.generated.model.UserInfoDto
import language_forest.mapper.UserMapper
import language_forest.mapper.UserStudyLanguageMapper
import language_forest.util.getUid
import language_forest.util.toUtcOffsetDateTime
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class UserInfoDelegateImpl(
    private val userInfoService: UserInfoService,
    private val userMapper: UserMapper,
    private val userStudyLanguageMapper: UserStudyLanguageMapper
) : UserInfoApiDelegate {

    override fun getUserInfoMe(): ResponseEntity<UserInfoDto> {
        val uid = getUid()

        // 서비스 호출
        val user = userInfoService.getUser(uid)
        val studyLanguages = userInfoService.getUserStudyLanguage(uid)

        // 엔터티 → DTO 변환
        val userDto = userMapper.fromEntityToBaseUser(user)
        val studyLanguageDTOs = studyLanguages.map { userStudyLanguageMapper.entityToBaseDto(it) }

        return ResponseEntity.ok(
            UserInfoDto(
                id = userDto.id,
                email = userDto.email,
                username = userDto.username,
                birthday = userDto.birthday,
                gender = userDto.gender,
                language = userDto.language,
                studyLanguages = studyLanguageDTOs,
                createdAt = userDto.createdAt,
                updatedAt = userDto.updatedAt,
                deletedAt = userDto.deletedAt
            )
        )
    }

    override fun createUserInfo(createUserInfoRequest: CreateUserInfoRequest): ResponseEntity<UserInfoDto> {
        val uid = getUid()

        val newUser = userMapper.fromCreateUserInfoRequestToEntity(createUserInfoRequest)
        val updatedUser = userInfoService.updateUser(newUser)


        // StudyLanguages 생성
        if (createUserInfoRequest.studyLanguages != null) {
            val newStudyLanguages =createUserInfoRequest.studyLanguages.map {
                userStudyLanguageMapper.fromCreateUserInfoRequestAllOfStudyLanguagesInnerToEntity(it)
            }
            val updatedStudyLanguages = newStudyLanguages.map {
                userStudyLanguageMapper.fromBaseDtoToEntity(userInfoService.createUserStudyLanguage(uid, it))
            }
            return ResponseEntity.ok(

                UserInfoDto(
                    id = updatedUser.id,
                    email = updatedUser.email,
                    username = updatedUser.username,
                    birthday = updatedUser.birthday,
                    gender = updatedUser.gender,
                    language = updatedUser.language,
                    studyLanguages = updatedStudyLanguages,
                    createdAt = updatedUser.createdAt.toUtcOffsetDateTime(),
                    updatedAt = updatedUser.updatedAt.toUtcOffsetDateTime(),
                    deletedAt = updatedUser.deletedAt?.toUtcOffsetDateTime()
                )
            )
        }

        return ResponseEntity.ok(
            UserInfoDto(
                id = updatedUser.id,
                email = updatedUser.email,
                username = updatedUser.username,
                birthday = updatedUser.birthday,
                gender = updatedUser.gender,
                language = updatedUser.language,
            )
        )
    }
}
