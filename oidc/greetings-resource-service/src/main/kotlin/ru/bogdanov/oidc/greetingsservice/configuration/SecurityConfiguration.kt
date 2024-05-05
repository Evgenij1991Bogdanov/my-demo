package ru.bogdanov.oidc.greetingsservice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration(proxyBeanMethods = false)
class SecurityConfiguration {

    @Bean
    fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain =
        http
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange { auth ->
                auth.anyExchange().authenticated()
            }
            .oauth2ResourceServer { oauth2ResourceServer ->
                oauth2ResourceServer.jwt { jwt ->
                    val jwtAuthenticationConverter = ReactiveJwtAuthenticationConverter().apply {
                        setPrincipalClaimName("preferred_username")
                    }
                    jwt.jwtAuthenticationConverter(jwtAuthenticationConverter)
                }
            }
            .build()

}
