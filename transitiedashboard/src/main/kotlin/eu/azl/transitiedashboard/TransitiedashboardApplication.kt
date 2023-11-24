package eu.azl.transitiedashboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.server.ResponseStatusException

@SpringBootApplication
class TransitiedashboardApplication

fun main(args: Array<String>) {
	runApplication<TransitiedashboardApplication>(*args)
}

