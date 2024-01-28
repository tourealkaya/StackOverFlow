package fr.mastersid.toure.stackoverflow.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import fr.mastersid.toure.stackoverflow.ui.Question

class QuestionMoshiAdapter {
    @FromJson
    fun fromJson(listQuestionJson: ListQuestionJson):List<Question>{
        return listQuestionJson.items.map {
                questionJson ->
            Question(questionJson.question_id,questionJson.title,questionJson.answer_count)
        }
    }
    @ToJson
    fun toJson(listQuestion:List<Question>):ListQuestionJson{
        return ListQuestionJson(
            listQuestion.map { question ->
                QuestionJson(question.id,question.title,question.answerCount)
            })
    }
}