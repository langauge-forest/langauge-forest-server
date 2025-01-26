/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.10.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
*/
package language_forest.generated.api

import language_forest.generated.model.CreateStudyRequest
import language_forest.generated.model.StudyResponse
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
interface StudyApi {

    fun getDelegate(): StudyApiDelegate = object: StudyApiDelegate {}


    @RequestMapping(
            method = [RequestMethod.POST],
            value = ["/study"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createStudy( @Valid @RequestBody createStudyRequest: CreateStudyRequest): ResponseEntity<StudyResponse> {
        return getDelegate().createStudy(createStudyRequest)
    }
}
