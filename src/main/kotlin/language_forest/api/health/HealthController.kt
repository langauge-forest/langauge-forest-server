package language_forest.api.health

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthController {
    @GetMapping
    fun getHealth(): ResponseEntity<Map<String, String>> {
        val imageTag = System.getenv("IMAGE_TAG") ?: "unknown"
        return ResponseEntity.ok(mapOf("status" to "UP", "imageTag" to imageTag)) // ✅ 반드시 200 반환
    }
}