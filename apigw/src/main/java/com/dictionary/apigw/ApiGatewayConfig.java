package com.dictionary.apigw;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ApiGatewayConfig {

    private final AuthFilter authFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user", r -> r.path("/api/auth/**").filters(f -> f.filter(authFilter)).uri("lb://USER"))
                .route("dictionary", r -> r.path("/api/dictionaries/**").filters(f -> f.filter(authFilter)).uri("lb://DICTIONARY"))
                .route("group", r -> r.path("/api/groups/**").filters(f -> f.filter(authFilter)).uri("lb://GROUP"))
                .route("word", r -> r.path("/api/words/**").filters(f -> f.filter(authFilter)).uri("lb://WORD"))
                .route("sentence", r -> r.path("/api/sentences/**").filters(f -> f.filter(authFilter)).uri("lb://SENTENCE"))
                .route("grammars", r -> r.path("/api/grammars/**").filters(f -> f.filter(authFilter)).uri("lb://GRAMMAR"))
                .route("texts", r -> r.path("/api/texts/**").filters(f -> f.filter(authFilter)).uri("lb://TEXT"))
                .build();
    }
}
