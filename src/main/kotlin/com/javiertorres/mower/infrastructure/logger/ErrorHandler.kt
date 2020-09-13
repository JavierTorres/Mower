package com.javiertorres.mower.infrastructure.logger

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NOT_IMPLEMENTED
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException?): ResponseEntity<Void> {
        LOGGER.info("Bad request", ex)
        return ResponseEntity
            .badRequest()
            .contentType(APPLICATION_JSON)
            .build()
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException?): ResponseEntity<Void> {
        LOGGER.info("Bad request", ex)
        return ResponseEntity
            .badRequest()
            .contentType(APPLICATION_JSON)
            .build()
    }

    @ExceptionHandler(UnsupportedOperationException::class)
    fun handleUnsupportedOperationException(ex: UnsupportedOperationException?): ResponseEntity<Void> {
        LOGGER.info("Unimplemented method", ex)
        return ResponseEntity
            .status(NOT_IMPLEMENTED)
            .contentType(APPLICATION_JSON)
            .build()
    }

    @ExceptionHandler(NotImplementedError::class)
    fun handleNotImplementedError(ex: NotImplementedError): ResponseEntity<Void> {
        LOGGER.info("Unimplemented method", ex)
        return ResponseEntity
            .status(NOT_IMPLEMENTED)
            .contentType(APPLICATION_JSON)
            .build()
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException): ResponseEntity<Void> {
        LOGGER.error("Unexpected error", ex)
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .contentType(APPLICATION_JSON)
            .build()
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ErrorHandler::class.java)
    }
}
