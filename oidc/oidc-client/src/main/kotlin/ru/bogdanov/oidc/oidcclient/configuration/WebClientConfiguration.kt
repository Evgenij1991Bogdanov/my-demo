package ru.bogdanov.oidc.oidcclient.configuration

import org.springframework.boot.web.codec.CodecCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient

@Configuration(proxyBeanMethods = false)
class WebClientConfiguration {

    @Bean
    fun greetingWebClient(
        customWebClientBuilder: WebClient.Builder,
        serverOAuth2AuthorizedClientExchangeFilterFunction: ExchangeFilterFunction
    ) = customWebClientBuilder.baseUrl("http://localhost:8082")
            .filter(serverOAuth2AuthorizedClientExchangeFilterFunction).build()


    @Bean
    fun serverOAuth2AuthorizedClientExchangeFilterFunction(
        clientRegistrationRepository: ReactiveClientRegistrationRepository,
        authorizedClientRepository: ServerOAuth2AuthorizedClientRepository,
    ): ServerOAuth2AuthorizedClientExchangeFilterFunction {
        val function = ServerOAuth2AuthorizedClientExchangeFilterFunction(
            clientRegistrationRepository, authorizedClientRepository
        )
        function.setDefaultClientRegistrationId("greetings-app-authorization-code")
        return function

    }

}
