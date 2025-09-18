package com.amarj.repository

import com.amarj.model.UserDashboard
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface UserDashboardRepository : ReactiveCrudRepository<UserDashboard, Long> {
}