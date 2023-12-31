package eu.azl.transitiedashboard

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
class HelloWorldController {
    @GetMapping("/")
    fun helloWorld(): String = "Hello World!"

    @GetMapping("/firstName/{firstName}/lastName/{lastName}")
    fun helloName(
        @PathVariable firstName: String,
        @PathVariable lastName: String,
    ): String = "Hello $lastName $firstName"

    @GetMapping("/query")
    fun hello(
        @RequestParam name: String,
    ): String = "Hello $name"

    @GetMapping("/order/{id}")
    fun ontploft(): String {
        throw OrderNotFound(5)
    }
}

class OrderNotFound(
    id: Int,
) : ResponseStatusException(
        HttpStatus.NOT_FOUND,
        "Order with id: $id not found",
    )
