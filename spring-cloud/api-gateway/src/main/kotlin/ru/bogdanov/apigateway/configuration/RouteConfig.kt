package ru.bogdanov.apigateway.configuration

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration(proxyBeanMethods = false)
class RouteConfig {

    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder): RouteLocator =
        builder.routes()
            .route("evgen") { r ->
                r.path("/evgen/hello-1")
                    .filters { f ->
                        f.rewritePath("/evgen/hello-1", "/hello")
                        f.tokenRelay()
                    }
                    .uri("lb://HELLO-WORLD-SERVICE-1")
            }
            .route("evgen") { r ->
                r.path("/evgen/hello-2")
                    .filters { f ->
                        f.rewritePath("/evgen/hello-2", "/hello")
                        f.tokenRelay()
                    }
                    .uri("lb://HELLO-WORLD-SERVICE-2")
            }
            .build()

}
