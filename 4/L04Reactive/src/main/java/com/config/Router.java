package com.config;

import com.entity.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;

@Configuration
public class Router {
    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> getString() {
        return RouterFunctions.nest(
                path("/user"),

                RouterFunctions
                        .route(GET("/getuserid"), userHandler::getUserId)
                        .andRoute(GET("/getusername"), userHandler::getUserName)
                        .andRoute(GET("/notify"), userHandler::notifyNewUser)
        );
    }
}
