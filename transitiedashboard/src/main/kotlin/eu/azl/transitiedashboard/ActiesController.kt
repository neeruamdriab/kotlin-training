package eu.azl.transitiedashboard

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

data class ActiesPost(
    val fondsId: Long,
    val titel: String? = null,
    val omschrijving: String? = null,
)

data class ActiesPut(
    val fondsId: Long,
    val id: Int,
    val titel: String? = null,
    val omschrijving: String? = null,
    val status: ActieStatus,
)

/**
 * Controller for handling CRUD operations on actions (Acties) within the application.
 *
 * This controller provides endpoints for creating, updating, and deleting actions.
 *
 * @property actiesRepository The repository responsible for handling data operations related to actions.
 */
@RestController
class ActiesController
    @Autowired
    constructor(
        private val actiesRepository: ActiesRepository,
    ) {
        /**
         * Creates a new action based on the provided data.
         *
         * @param post The data for creating a new action, including fund ID, title, and description.
         * @return The ID of the newly created action.
         */
        @PostMapping("/api/Acties")
        fun createAction(
            @RequestBody post: ActiesPost,
        ): Long {
            return actiesRepository.insert(post)
        }

        /**
         * Updates an existing action based on the provided data.
         *
         * @param put The data for updating an action, including fund ID, action ID, title, description, and status.
         */
        @PutMapping("/api/Acties/{actieId}")
        fun updateAction(
            @RequestBody put: ActiesPut,
        ) {
            actiesRepository.update(put)
        }

        /**
         * Deletes an action based on the provided action ID.
         *
         * @param actieId The ID of the action to be deleted.
         * @return A message indicating the success of the deletion.
         */
        @DeleteMapping("/api/Acties/{actieId}")
        fun deleteAction(
            @PathVariable actieId: Long,
        ): String {
            actiesRepository.delete(actieId)
            return "The entry has been deleted"
        }
    }
