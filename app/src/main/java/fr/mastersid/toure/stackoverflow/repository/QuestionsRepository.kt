package fr.mastersid.toure.stackoverflow.repository

import fr.mastersid.toure.stackoverflow.ui.Question
import kotlinx.coroutines.flow.Flow

interface QuestionsRepository {
    val questionsResponse: Flow<QuestionsResponse>
    suspend fun updateuestionsInfo()
}