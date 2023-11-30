package eu.azl.transitiedashboard

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

/**
 * Enum representing the possible status values for an action.
 */
enum class ActieStatus {
    Open,
    Afgerond,
    Geannuleerd,
}

/**
 * Repository service for managing actions in the database.
 *
 * @property template The JDBC template for executing SQL queries.
 */
@Service
class ActiesRepository(
    private val template: JdbcTemplate,
) {
    /**
     * Inserts a new action into the database.
     *
     * @param post The data for the new action.
     * @return The ID of the newly inserted action.
     */
    fun insert(post: ActiesPost): Long =
        template.queryForObject(
            """
            INSERT INTO acties(fondsId, titel, omschrijving, status)
            VALUES (?, ?, ?, ?)
            RETURNING id
            """.trimIndent(),
            Long::class.java,
            post.fondsId,
            post.titel,
            post.omschrijving,
            ActieStatus.Open.name,
        )

    /**
     * Updates an existing action in the database.
     *
     * @param put The updated data for the action.
     */
    fun update(put: ActiesPut) {
        template.update(
            """
            UPDATE acties
            SET fondsId = ?, titel = ?, omschrijving = ?, status = ?
            WHERE id = ?
            """.trimIndent(),
            put.fondsId,
            put.titel,
            put.omschrijving,
            put.status.name,
            put.id,
        )
    }

    /**
     * Deletes an action from the database.
     *
     * @param actiesId The ID of the action to be deleted.
     */
    fun delete(actiesId: Long) =
        template.update(
            """
            DELETE FROM acties
            WHERE id = ?
            """.trimIndent(),
            actiesId,
        )
}
