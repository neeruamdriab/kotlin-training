package eu.azl.transitiedashboard

// import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

// import org.springframework.test.web.reactive.server.

@SpringBootTest
@Testcontainers
class HelloWorldControllerTest {
    companion object {
        @ServiceConnection
        @Container
        val postgres =
            PostgreSQLContainer("postgres:latest")
    }

    val client =
        WebTestClient
            .bindToController(HelloWorldController())
            .build()

    @Test
    fun helloWorld() {
        val response =
            client.get()
                .uri("/")
                .exchange()

        response
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .isEqualTo("Hello World!")
    }

    @Test
    fun helloName() {
        val response =
            client.get()
                .uri("/firstName/{firstName}/lastName/{lastName}", "fred", "manders")
                .exchange()

        response
            .expectStatus().isOk
            .expectBody(String::class.java)
            .isEqualTo("Hello manders fred")
    }

    @Test
    fun hello() {
        val response =
            client.get()
                .uri { builder ->
                    builder
                        .path("/query")
                        .queryParam("name", "henk")
                        .build()
                }
                .exchange()

        response
            .expectStatus().isOk
            .expectBody(String::class.java)
            .isEqualTo("Hello henk")
    }

    @Test
    fun ontploft() {
        val response =
            client.get()
                .uri("/order/{id}", 5)
                .exchange()

        response
            .expectStatus().isNotFound
            .expectBody()
//            .jsonPath("$[0].message")
//            .isEqualTo("Jane")
    }
}
