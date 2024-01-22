package fr.mastersid.toure.stackoverflow.repository

import fr.mastersid.toure.stackoverflow.ui.Question
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class QuestionsRepositoryDummyImpl @Inject constructor() : QuestionsRepository{
    override val questionsResponse: MutableStateFlow<QuestionsResponse> = MutableStateFlow(
        QuestionsResponse.Success(emptyList())
    )

    override suspend fun updateuestionsInfo() {
        questionsResponse.emit(QuestionsResponse.Pending)
        delay(2000)
        questionsResponse.emit(
            QuestionsResponse.Success(
                listOf(
                    Question(1, "Kotlin doesn't work", 3, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor."),
                    Question(2, "short question", 1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. sed non risus. Suspendisse lectus tortor, dignissim sit amet, adipiscing nec, ultricies sed, dolor."),
                    Question(3, "A very very very very very very long question", 3, "Lorem ipsum dolor sit amet, consectet")
                )
            )
        )
    }
}