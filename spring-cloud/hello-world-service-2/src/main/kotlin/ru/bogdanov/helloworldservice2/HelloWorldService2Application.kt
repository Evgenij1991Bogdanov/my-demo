package ru.bogdanov.helloworldservice2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableDiscoveryClient
class HelloWorldService2Application

fun main(args: Array<String>) {
    runApplication<HelloWorldService2Application>(*args)
}


@RestController
class HelloController {

    @GetMapping("/hello")
    fun execute(serverHttpRequest: ServerHttpRequest): String {
        val jwt = serverHttpRequest.headers.getFirst("Authorization")
            ?.substring(0, 30)
        return "Hello from service 2. \nYour jwt = $jwt ..."
    }
}