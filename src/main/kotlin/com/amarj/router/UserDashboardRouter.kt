package com.amarj.router

import com.amarj.handler.UserDashboardHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class UserDashboardRouter {

    @Bean
    fun route(handler: UserDashboardHandler): RouterFunction<ServerResponse> = router {
        "/api/dashboards".nest {
            POST("", handler::create)
            GET("", handler::list)
            GET("/{id}", handler::get)
            PUT("/{id}", handler::update)
            DELETE("/{id}", handler::delete)
        }
    }
}