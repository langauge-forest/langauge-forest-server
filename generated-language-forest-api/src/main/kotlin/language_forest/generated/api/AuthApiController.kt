package language_forest.generated.api

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import java.util.Optional

@jakarta.annotation.Generated(value = ["org.openapitools.codegen.languages.KotlinSpringServerCodegen"], comments = "Generator version: 7.10.0")
@Controller
@RequestMapping("\${openapi.sample.base-path:}")
class AuthApiController(
        delegate: AuthApiDelegate?
) : AuthApi {
    private lateinit var delegate: AuthApiDelegate

    init {
        this.delegate = Optional.ofNullable(delegate).orElse(object : AuthApiDelegate {})
    }

    override fun getDelegate(): AuthApiDelegate = delegate
}
