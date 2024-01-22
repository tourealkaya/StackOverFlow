package fr.mastersid.toure.stackoverflow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mastersid.toure.stackoverflow.repository.QuestionsRepository
import fr.mastersid.toure.stackoverflow.repository.QuestionsResponse
import fr.mastersid.toure.stackoverflow.ui.Question
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel

class QuestionsViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository

): ViewModel(

){

    private val _questionsList : MutableLiveData<List<Question>> = MutableLiveData(emptyList())
    val questionsList: LiveData<List<Question>> = _questionsList

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch(Dispatchers.IO){
            questionsRepository.questionsResponse.collect{ response ->
                when(response){
                    is QuestionsResponse.Pending ->  _isLoading.postValue(true)

                    is QuestionsResponse.Success -> {
                        _isLoading.postValue(false)
                        _questionsList.postValue(response.list)

                    }
                }

            }
        }
    }

    fun updateQuestionsList(){
        viewModelScope.launch(Dispatchers.IO){
            questionsRepository.updateuestionsInfo()
        }
    }

}