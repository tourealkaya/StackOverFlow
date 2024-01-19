package fr.mastersid.toure.stackoverflow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fr.mastersid.toure.stackoverflow.ui.Question

class QuestionsViewModel {
    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = _questions

    var isUpdating = false

    fun updateQuestions() {
        isUpdating = true
        _questions.value = listOf(
            Question(1, "Question 1", 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
            Question(2, "Question 2", 22, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
            Question(3, "Question 3", 12, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
            Question(4, "Question 4", 4, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "),
        )
    }
}