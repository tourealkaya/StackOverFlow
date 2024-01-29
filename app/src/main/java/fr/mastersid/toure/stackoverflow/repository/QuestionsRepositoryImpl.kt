package fr.mastersid.toure.stackoverflow.repository

import fr.mastersid.toure.stackoverflow.CoroutineScopeIO
import fr.mastersid.toure.stackoverflow.database.QuestionDao
import fr.mastersid.toure.stackoverflow.ui.Question
import fr.mastersid.toure.stackoverflow.webservice.QuestionsWebService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.text.Normalizer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuestionsRepositoryImpl @Inject constructor(
    private val questionsWebService: QuestionsWebService,
    private val questionDao: QuestionDao,
    @CoroutineScopeIO private val  coroutineScopeIO: CoroutineScope
) : QuestionsRepository{
    override val questionsResponse: MutableStateFlow<QuestionsResponse> = MutableStateFlow(
        QuestionsResponse.Success(emptyList())
    )
    init {
        coroutineScopeIO.launch{
            questionDao.getQuestionListFlow().collect{list->
                questionsResponse.emit(QuestionsResponse.Success(list))

            }
        }
    }


    override suspend fun updateuestionsInfo(){
        val list = questionsWebService
            .getQuestionsList( order = "desc", sort = "activity", site = "stackoverflow")
        questionDao.insertAll(list.distinctBy { question ->
            "\\p{InCombiningDiacriticalMarks}"
                .toRegex()
                .replace(
                    Normalizer.normalize(question.title, Normalizer.Form.NFD),
                    ""
                )

        })
       // questionsResponse.emit(QuestionsResponse.Success(list))
    }
}
