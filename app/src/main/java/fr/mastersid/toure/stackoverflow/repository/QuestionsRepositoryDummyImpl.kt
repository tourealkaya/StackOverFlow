package fr.mastersid.toure.stackoverflow.repository

import android.util.Log
import fr.mastersid.toure.stackoverflow.ui.Question
import fr.mastersid.toure.stackoverflow.webservice.QuestionsWebService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback

class QuestionsRepositoryDummyImpl @Inject constructor(
    private val questionsWebService: QuestionsWebService
) : QuestionsRepository{
    override val questionsResponse: MutableStateFlow<QuestionsResponse> = MutableStateFlow(
        QuestionsResponse.Success(emptyList())
    )


    override suspend fun updateuestionsInfo(){
        val list = questionsWebService
            .getQuestionsList( order = "desc", sort = "activity", site = "stackoverflow")
        questionsResponse.emit(QuestionsResponse.Success(list))
    }
}
