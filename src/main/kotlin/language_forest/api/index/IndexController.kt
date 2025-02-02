package language_forest.api.index

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class IndexController {

    private val projectVersion: String = System.getProperty("project.version") ?: "unknown"

    @GetMapping
    fun getImageTag(): Map<String, String> {
        val imageTag = System.getenv("IMAGE_TAG") ?: projectVersion
        return mapOf("imageTag" to imageTag)
    }
}
