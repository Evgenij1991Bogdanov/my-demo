package ru.bogdanov.oidc.greetingsservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GreetingsServiceApplication

fun main(args: Array<String>) {
    runApplication<GreetingsServiceApplication>(*args)
}
