package ru.bogdanov.oidc.greetingsservice.controller

import java.security.Principal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greetings")
class GreetingsController {

    @GetMapping
    suspend fun getGreeting(principal: Principal?): Greeting {
        return Greeting("Будь как дома, ${principal?.name ?: "Путник"}")
    }

}


data class Greeting(val greeting: String)