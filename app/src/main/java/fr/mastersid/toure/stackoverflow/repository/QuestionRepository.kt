package fr.mastersid.toure.stackoverflow.repository


import fr.mastersid.toure.stackoverflow.ui.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

//On utilisera l’injection fournie par Hilt.

class QuestionRepository @Inject constructor()  {
    private val _questionsResponse = MutableSharedFlow<QuestionsResponse>()
    val questionsResponse: Flow<QuestionsResponse> = _questionsResponse.asSharedFlow()

    suspend fun updateQuestionsInfo() {
        _questionsResponse.emit(QuestionsResponse.Pending)
        // Récupérez les nouvelles questions ici
        // Par exemple :
        val newQuestions = listOf(
            Question(1, "Question 1", 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
            Question(2, "Question 2", 22, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
            Question(3, "Question 3", 12, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
            Question(4, "Question 4", 4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
        )
       // _questionsResponse.emit(QuestionsResponse.Success(newQuestions))
    }
}