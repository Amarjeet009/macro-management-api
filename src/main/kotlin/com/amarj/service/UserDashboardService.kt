package com.amarj.service

import com.amarj.dto.UserDashboardRequest
import com.amarj.dto.UserDashboardResponse
import com.amarj.dto.toResponse
import com.amarj.exception.DashboardNotFoundException
import com.amarj.model.UserDashboard
import com.amarj.repository.UserDashboardRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Instant
import java.time.LocalDateTime

@Service
class UserDashboardService (private val repo: UserDashboardRepository){

    fun createUserDashboard(req: UserDashboardRequest): Mono<UserDashboardResponse> =
        repo.save(
            UserDashboard(
                name = req.name,
                title = req.title,
                description = req.description,
                rating = req.rating,
                createdAt = LocalDateTime.now()
            )
        ).map { it.toResponse() }

    fun getAllUserDashboardList(id: Long): Mono<UserDashboardResponse> =
        repo.findById(id)
            .switchIfEmpty(Mono.error(DashboardNotFoundException(id)))
            .map { it.toResponse() }

    fun updateUserDashboard(id: Long, req: UserDashboardRequest): Mono<UserDashboardResponse> =
        repo.findById(id)
            .switchIfEmpty(Mono.error(DashboardNotFoundException(id)))
            .flatMap {
                val updated = it.copy(
                    name = req.name,
                    title = req.title,
                    description = req.description,
                    rating = req.rating
                )
                repo.save(updated)
            }.map { it.toResponse() }

    fun deleteUserDashboard(id: Long): Mono<Void> =
        repo.findById(id)
            .switchIfEmpty(Mono.error(DashboardNotFoundException(id)))
            .flatMap { repo.delete(it) }

    fun listUserDashboard(): Flux<UserDashboardResponse> =
        repo.findAll().map { it.toResponse() }


}