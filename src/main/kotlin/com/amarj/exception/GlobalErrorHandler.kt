package com.amarj.exception

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
//
//@Configuration
//class GlobalErrorHandler : ErrorWebExceptionHandler {
//
//    override fun handle(
//        exchange: ServerWebExchange,
//        ex: Throwable
//    ): Mono<Void> {
//        val response = exchange.response
//        response.statusCode = HttpStatus.INTERNAL_SERVER_ERROR
//        val buffer = response.bufferFactory().wrap("{\"error\":\"${ex.message}\"}".toByteArray())
//        return response.writeWith(Mono.just(buffer))
//    }
//}

@RestControllerAdvice
class GlobalErrorHandler {

    @ExceptionHandler(DashboardNotFoundException::class)
    fun handleNotFound(ex: DashboardNotFoundException): ResponseEntity<Map<String, String>> =
        ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(mapOf("error" to ex.message!!))
}