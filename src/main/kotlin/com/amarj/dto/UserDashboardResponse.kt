package com.amarj.dto

import com.amarj.model.UserDashboard
import java.time.LocalDateTime

data class UserDashboardResponse(
    val id: Long,
    val name: String,
    val title: String,
    val description: String,
    val rating: Int,
    val createdAt: LocalDateTime
)

fun UserDashboard.toResponse() = UserDashboardResponse(
    id = id!!,
    name = name,
    title = title,
    description = description,
    rating = rating,
    createdAt = createdAt ?: LocalDateTime.now()
)