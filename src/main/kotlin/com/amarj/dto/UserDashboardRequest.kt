package com.amarj.dto

data class UserDashboardRequest(
    val name: String,
    val title: String,
    val description: String,
    val rating: Int
)