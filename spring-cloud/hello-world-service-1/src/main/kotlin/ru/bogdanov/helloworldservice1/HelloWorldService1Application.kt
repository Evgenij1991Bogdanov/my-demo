package ru.bogdanov.helloworldservice1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableDiscoveryClient
class HelloWorldService1Application

fun main(args: Array<String>) {
    runApplication<HelloWorldService1Application>(*args)
}

@RestController
class HelloController {

    @GetMapping("/hello")
    fun execute(serverHttpRequest: ServerHttpRequest): String {
        val jwt = serverHttpRequest.headers.getFirst("Authorization")
            ?.substring(0, 30)
        return "Hello from service 1. \nYour jwt = $jwt ..."
    }
}
