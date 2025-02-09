package language_forest.exception

import org.springframework.http.HttpStatus

sealed class ApiException(val status: HttpStatus, message: String) : RuntimeException(message)

class UnauthorizedException(message: String) : ApiException(HttpStatus.UNAUTHORIZED, message)
class BadRequestException(message: String) : ApiException(HttpStatus.BAD_REQUEST, message)
class NotFoundException(message: String) : ApiException(HttpStatus.NOT_FOUND, message)
class ForbiddenException(message: String) : ApiException(HttpStatus.FORBIDDEN, message)
class UpdateFailedException(message: String) : ApiException(HttpStatus.CONFLICT, message)
