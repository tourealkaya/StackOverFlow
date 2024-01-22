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
/*
    override suspend fun updateuestionsInfo() {
        questionsResponse.emit(QuestionsResponse.Pending)
        delay(2000)
        questionsResponse.emit(
            QuestionsResponse.Success(
                listOf(
                    Question(1, "Kotlin doesn't work", 34, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor."),
                    Question(2, "short question", 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor."),
                    Question(3, "A very very very very very very long question", 3, "Lorem ipsum dolor sit amet, consectet")
                )
            )
        )
    }*/

    override suspend fun updateuestionsInfo(){
        val list = questionsWebService
            .getQuestionsList( order = "desc", sort = "activity", site = "stackoverflow")
        Log.d("Web service", "list: $list")
    }
}
