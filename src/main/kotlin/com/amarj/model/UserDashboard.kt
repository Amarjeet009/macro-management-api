package com.amarj.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("user_dashboards")
data class UserDashboard(
    @Id
    val id: Long?=null,
    @Column("name")
    val name: String,
    @Column("title")
    val title: String,
    @Column("description")
    val description: String,
    @Column("rating")
    val rating: Int,
    @Column("created_at")
    val createdAt: LocalDateTime? = null
)
