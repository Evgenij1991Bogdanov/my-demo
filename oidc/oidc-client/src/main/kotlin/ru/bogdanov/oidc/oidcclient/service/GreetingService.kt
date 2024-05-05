package ru.bogdanov.oidc.oidcclient.service

import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class GreetingService(
    private val greetingWebClient: WebClient,
    private val authorizedClientManager: ReactiveOAuth2AuthorizedClientManager
) {


    suspend fun getGreetingFromResourceServer(): String {
//        val token = authorizedClientManager.authorize(OAuth2AuthorizeRequest
//            .withClientRegistrationId("greetings-app-authorization-code")
//            .principal("greeting-app")
//            .build())
//            .map {
//                it.accessToken.tokenValue
//            }
//            .awaitSingle()
//
//        println("Token = $token")

        return greetingWebClient
            .get()
            .uri("/greetings")
//            .header("Authorization", "Bearer $token")

            .retrieve()
            .bodyToMono(String::class.java)
            .awaitSingle()
    }


}
