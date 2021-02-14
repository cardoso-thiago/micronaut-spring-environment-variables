package br.com.cardoso.ev

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringEnvironmentVariablesApplication

fun main(args: Array<String>) {
    runApplication<SpringEnvironmentVariablesApplication>(*args)
}
