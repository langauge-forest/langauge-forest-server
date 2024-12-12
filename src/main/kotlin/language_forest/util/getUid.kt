package language_forest.util

import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

fun getUid(): UUID {
    val authentication = SecurityContextHolder.getContext().authentication
    return UUID.fromString(authentication.name)
}