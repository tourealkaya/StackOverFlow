package fr.mastersid.toure.stackoverflow.repository

import fr.mastersid.toure.stackoverflow.ui.Question

sealed interface QuestionsResponse {
    object Pending : QuestionsResponse
    @JvmInline
    value class Success(val questions: List<Question>) : QuestionsResponse
}