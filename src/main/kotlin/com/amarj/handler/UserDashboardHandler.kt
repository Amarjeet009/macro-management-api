package com.amarj.handler

import com.amarj.dto.UserDashboardRequest
import com.amarj.service.UserDashboardService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class UserDashboardHandler(private val service: UserDashboardService) {

    fun create(req: ServerRequest): Mono<ServerResponse> =
        req.bodyToMono(UserDashboardRequest::class.java)
            .flatMap { service.createUserDashboard(it) }
            .flatMap { ServerResponse.ok().bodyValue(it) }

    fun get(req: ServerRequest): Mono<ServerResponse> =
        service.getAllUserDashboardList(req.pathVariable("id").toLong())
            .flatMap { ServerResponse.ok().bodyValue(it) }

    fun update(req: ServerRequest): Mono<ServerResponse> =
        req.bodyToMono(UserDashboardRequest::class.java)
            .flatMap { dto -> service.updateUserDashboard(req.pathVariable("id").toLong(), dto) }
            .flatMap { ServerResponse.ok().bodyValue(it) }

    fun delete(req: ServerRequest): Mono<ServerResponse> =
        service.deleteUserDashboard(req.pathVariable("id").toLong())
            .then(ServerResponse.noContent().build())

    fun list(req: ServerRequest): Mono<ServerResponse> =
        service.listUserDashboard()
            .collectList()
            .flatMap { ServerResponse.ok().bodyValue(it) }
}