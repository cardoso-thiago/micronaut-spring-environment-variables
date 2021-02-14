package br.com.cardoso.controller

import io.micronaut.context.env.Environment
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import java.util.*

@Controller
class InfoController(private val environment: Environment) {

    @Get("/info")
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
                .add("$propertyUser ${environment.getProperty(propertyUser, String::class.java).get()}")
                .add("$propertyPassword ${environment.getProperty(propertyPassword, String::class.java).get()}")
                .toString()
    }
}