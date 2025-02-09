/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.10.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package language_forest.generated.api

import language_forest.generated.model.AppleLoginRequest
import language_forest.generated.model.AuthRefreshRequest
import language_forest.generated.model.GoogleLoginRequest
import language_forest.generated.model.TokenDto
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import jakarta.validation.constraints.DecimalMax
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import jakarta.validation.Valid

import kotlin.collections.List
import kotlin.collections.Map

@RestController
@Validated
interface AuthApi {

    fun getDelegate(): AuthApiDelegate = object: AuthApiDelegate {}


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/auth/apple"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun appleLogin( @Valid @RequestBody appleLoginRequest: AppleLoginRequest): ResponseEntity<TokenDto> {
        return getDelegate().appleLogin(appleLoginRequest)
    }


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/auth/refresh"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun authRefresh( @Valid @RequestBody authRefreshRequest: AuthRefreshRequest): ResponseEntity<TokenDto> {
        return getDelegate().authRefresh(authRefreshRequest)
    }


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/auth/dummy"],
            produces = ["application/json"]
    )
    fun dummyLogin(): ResponseEntity<TokenDto> {
        return getDelegate().dummyLogin()
    }


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/auth/google"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun googleLogin( @Valid @RequestBody googleLoginRequest: GoogleLoginRequest): ResponseEntity<TokenDto> {
        return getDelegate().googleLogin(googleLoginRequest)
    }
}
