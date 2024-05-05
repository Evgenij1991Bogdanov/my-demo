package ru.bogdanov.oidc.oidcclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OidcClientApplication

fun main(args: Array<String>) {
    runApplication<OidcClientApplication>(*args)
}
