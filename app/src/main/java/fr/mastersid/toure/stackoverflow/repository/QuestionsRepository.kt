package fr.mastersid.toure.stackoverflow.repository

import kotlinx.coroutines.flow.Flow

interface QuestionsRepository {
    val questionsResponse: Flow<QuestionsResponse>
    suspend fun updateuestionsInfo()
}