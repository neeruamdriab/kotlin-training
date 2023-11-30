package eu.azl.transitiedashboard

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

data class FondsenPost(
    val id: Int,
    val naam: String? = null,
    val status: String? = null,
    val statusToelichting: String? = null,
    val voortgang: Int? = null,
    val voortgangDelta: Int? = null,
    val kostenOmschrijving: String? = null,
)

data class FondsenGet(
    val id: Int,
    val naam: String? = null,
)

data class FondsenGetById(
    val id: Int,
    val naam: String? = null,
    val status: String? = null,
    val statusToelichting: String? = null,
    val voortgang: Int? = null,
    val voortgangDelta: Int? = null,
    val kostenOmschrijving: String? = null,
)

data class FondsenPut(
    val fondsId: Int,
    val naam: String? = null,
    val status: String? = null,
    val statusToelichting: String? = null,
    val voortgang: Int? = null,
    val voortgangDelta: Int? = null,
    val kostenOmschrijving: String? = null,
)

data class FondsDetails(
    val fondsenGetById: FondsenGetById,
    val acties: List<ActiesPut>,
)

@RestController
class FondsenController
    @Autowired
    constructor(
        private val fondsenRepository: FondsenRepository,
    ) {
        @PostMapping("/api/Fondsen")
        fun createFonds(
            @RequestBody post: FondsenPost,
        ): Long {
            return fondsenRepository.insert(post)
        }

        /**
         * Retrieves a list of all funds with their names and IDs.
         *
         * @return A list of pairs containing the fund ID and name.
         */
        @GetMapping("/api/Fondsen")
        fun getAllFunds(): List<FondsenGet> {
            return fondsenRepository.retrieveAllFunds()
        }

        @GetMapping("/api/Fondsen/{fondsId}")
        fun getFundById(
            @PathVariable fondsId: Long,
        ): FondsDetails? {
            return fondsenRepository.retrieveFundById(fondsId)
        }

        @PutMapping("/api/Fondsen/{fondsId}")
        fun updateFund(
            @RequestBody put: FondsenPut,
        ) {
            println("PUT request received for fund ID: ${put.fondsId}")
            fondsenRepository.update(put)
        }

        @DeleteMapping("/api/Fondsen/{fondsId}")
        fun deleteFund(
            @PathVariable fondsId: Long,
        ): String {
            fondsenRepository.delete(fondsId)
            return "The entry has been deleted"
        }
    }
