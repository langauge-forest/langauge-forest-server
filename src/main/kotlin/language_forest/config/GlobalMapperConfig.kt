package language_forest.config

import org.mapstruct.MapperConfig
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

// 1. 헬퍼 클래스
object DateTimeConverter {
    @JvmStatic
    fun map(offset: OffsetDateTime?): LocalDateTime? = offset?.toLocalDateTime()

    @JvmStatic
    fun map(local: LocalDateTime?): OffsetDateTime? = local?.atOffset(ZoneOffset.UTC)
}

// 2. 전역 MapperConfig
@MapperConfig(
    uses = [DateTimeConverter::class]
)
interface GlobalMapperConfig