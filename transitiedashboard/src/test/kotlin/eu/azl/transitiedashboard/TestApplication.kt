package eu.azl.transitiedashboard

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer

@TestConfiguration(proxyBeanMethods = false)
class MyTestConfiguration {
    @Bean
    @ServiceConnection
    fun postgres() = PostgreSQLContainer("postgres:latest")
}

fun main(args: Array<String>) {
    fromApplication<TransitiedashboardApplication>()
        .with(MyTestConfiguration::class.java)
        .run(*args)
}
