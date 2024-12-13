package language_forest.generated.api

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import java.util.Optional

@jakarta.annotation.Generated(value = ["org.openapitools.codegen.languages.KotlinSpringServerCodegen"], comments = "Generator version: 7.10.0")
@Controller
@RequestMapping("\${openapi.sample.base-path:}")
class HelloApiController(
        delegate: HelloApiDelegate?
) : HelloApi {
    private lateinit var delegate: HelloApiDelegate

    init {
        this.delegate = Optional.ofNullable(delegate).orElse(object : HelloApiDelegate {})
    }

    override fun getDelegate(): HelloApiDelegate = delegate
}
