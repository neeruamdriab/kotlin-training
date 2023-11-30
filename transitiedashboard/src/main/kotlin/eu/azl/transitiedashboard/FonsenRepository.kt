package eu.azl.transitiedashboard

import org.springframework.jdbc.core.DataClassRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

/**
 * Repository service for managing funds in the database.
 *
 * @property template The JDBC template for executing SQL queries.
 */
@Service
class FondsenRepository(
    private val template: JdbcTemplate,
) {
    /**
     * Inserts a new fund into the database.
     *
     * @param post The data for the new action.
     * @return The ID of the newly inserted action.
     */
    fun insert(post: FondsenPost): Long =
        template.queryForObject(
            """
            INSERT INTO fondsen(naam, status, statusToelichting, voortgang, voortgangDelta, kostenOmschrijving)
            VALUES (?, ?, ?, ?, ?, ?)
            RETURNING id
            """.trimIndent(),
            Long::class.java,
            post.naam,
            post.status,
            post.statusToelichting,
            post.voortgang,
            post.voortgangDelta,
            post.kostenOmschrijving,
        )

    /**
     * Retrieves a list of all funds with their names and IDs from the database.
     *
     * @return A list of pairs containing the fund ID and name.
     */
    fun retrieveAllFunds(): List<FondsenGet> =
        template.query(
            """
            SELECT id, naam
            FROM fondsen
            """.trimIndent(),
        ) { rs, _ ->
            FondsenGet(
                id = rs.getLong("id").toInt(),
                naam = rs.getString("naam"),
            )
        }

    fun retrieveFundById(fondsId: Long): FondsDetails? {
        val fondsen =
            template.queryForObject(
                """
                SELECT id, naam, status, statusToelichting, voortgang, voortgangDelta, kostenOmschrijving
                FROM fondsen
                WHERE id = ?
                """.trimIndent(),
                DataClassRowMapper(FondsenGetById::class.java),
                fondsId.toInt(),
            )

        val acties =
            template.query(
                """
                SELECT id, fondsId, titel, omschrijving, status
                FROM acties
                """.trimIndent(),
                DataClassRowMapper(ActiesPut::class.java), // ,fondsId.toInt()
            )

        println(acties)

        return if (fondsen != null) {
            println("Gaat goed")
            FondsDetails(fondsen, acties)
        } else {
            println("Gaat niet goed")
            null
        }
    }

    fun update(put: FondsenPut) =
        template.update(
            """
            UPDATE fondsen
            SET naam = ?, status = ?, statusToelichting = ?, voortgang = ?, voortgangDelta = ?, kostenOmschrijving = ?
            WHERE id = ?
            """.trimIndent(),
            put.naam,
            put.status,
            put.statusToelichting,
            put.voortgang,
            put.voortgangDelta,
            put.kostenOmschrijving,
            put.fondsId,
        )

    fun delete(actiesId: Long) =
        template.update(
            """
            DELETE FROM fondsen
            WHERE id = ?
            """.trimIndent(),
            actiesId,
        )
}
