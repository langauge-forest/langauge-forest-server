package language_forest.util

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

fun LocalDateTime.toUtcOffsetDateTime(): OffsetDateTime {
    return this.atOffset(ZoneOffset.UTC)
}