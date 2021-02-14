package br.com.cardoso.ev.controller

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class InfoController(private val environment: Environment) {

    @GetMapping("/info")
    fun getSystemInfo(): String {
        val systemUser = "system.user"
        val systemPassword = "system.password"
        val propertyUser = "property.user"
        val propertyPassword = "property.password"

        return StringJoiner("\n")
                .add("$systemUser ${System.getProperty(systemUser)}")
                .add("$systemPassword ${System.getProperty(systemPassword)}")
                .add("env $systemUser ${System.getenv(systemUser)}")
                .add("env $systemPassword ${System.getenv(systemPassword)}")
                .add("$propertyUser ${environment.getProperty(propertyUser)}")
                .add("$propertyPassword ${environment.getProperty(propertyPassword)}")
                .toString()
    }
}