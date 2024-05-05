package ru.bogdanov.oidc.oidcclient.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.bogdanov.oidc.oidcclient.service.GreetingService

@RestController
class OIDCClientDemoController(
    private val greetingService: GreetingService,
) {

    @GetMapping("/greeting")
    suspend fun getGreetingFromResourceServer(): String = greetingService.getGreetingFromResourceServer()

}
