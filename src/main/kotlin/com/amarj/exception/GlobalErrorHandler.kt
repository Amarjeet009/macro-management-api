package com.amarj.exception

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Configuration
class GlobalErrorHandler : ErrorWebExceptionHandler {

    override fun handle(
        exchange: ServerWebExchange,
        ex: Throwable
    ): Mono<Void> {
        val response = exchange.response
        response.statusCode = HttpStatus.INTERNAL_SERVER_ERROR
        val buffer = response.bufferFactory().wrap("{\"error\":\"${ex.message}\"}".toByteArray())
        return response.writeWith(Mono.just(buffer))
    }
}