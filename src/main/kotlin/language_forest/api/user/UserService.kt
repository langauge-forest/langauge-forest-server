package language_forest.api.user

import language_forest.entity.User
import language_forest.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun getUserMe(uid: UUID): User {
        return userRepository.findById(uid).orElseThrow {
            throw RuntimeException("User not found for uid: $uid")
        }
    }
}