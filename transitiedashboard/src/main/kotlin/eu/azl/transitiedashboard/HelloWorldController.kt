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
    fun helloWorld(): String =
        "Hello world"

    @GetMapping("/{name}")

    fun helloName(@PathVariable name: String): String =
        "Hello $name"

    @GetMapping("/query")
    fun hello(@RequestParam name: String): String =
        "Hello $name"

    @GetMapping("/ontploft")
    fun ontploft(): String =
        throw OrderNotFound(1)

}

class OrderNotFound(
    id: Long
) : ResponseStatusException(
    HttpStatus.NOT_FOUND,
    "Order with id: $id not found"
)