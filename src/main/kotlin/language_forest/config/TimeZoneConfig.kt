package language_forest.config

import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Configuration
import java.util.TimeZone

@Configuration
class TimeZoneConfig {

    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
        println("Default TimeZone set to UTC")
    }
}