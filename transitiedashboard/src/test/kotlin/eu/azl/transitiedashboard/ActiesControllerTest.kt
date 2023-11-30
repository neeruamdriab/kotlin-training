package eu.azl.transitiedashboard

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@Testcontainers
class ActiesControllerTest {
    companion object {
        @ServiceConnection
        @Container
        val postgres =
            PostgreSQLContainer("postgres:latest")
    }
}
