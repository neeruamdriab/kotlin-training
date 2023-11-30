package eu.azl.transitiedashboard

import org.springframework.jdbc.core.DataClassRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class Orders(private val template: JdbcTemplate) {
    fun insert(
        name: String,
        amount: Int,
    ): Long =
        template.queryForObject(
            """
            INSERT INTO orders
            VALUES (?, ?)
            RETURNING id
            """.trimIndent(),
            Long::class.java,
            amount,
        )

    private val mapper = DataClassRowMapper(Order::class.java)

    fun select(id: Long): Order? =
        template.queryForObject(
            """
            SELECT id, name, amount
            FROM orders
            WHERE id = ?
            """.trimIndent(),
            mapper,
            id,
        )

    fun selectAll(): List<Order> =
        template.query(
            """
            SELECT id, name, amount
            FROM orders
            """.trimIndent(),
            mapper,
        )
}

data class Order(
    val id: Long,
    val name: String,
    val amount: Int,
)
