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
            POST("/save", handler::create)
            GET("/getAll", handler::list)
            GET("/getBy/{id}", handler::get)
            PUT("/updateBy/{id}", handler::update)
            DELETE("/deleteBy/{id}", handler::delete)
        }
    }
}
