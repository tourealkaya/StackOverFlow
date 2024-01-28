package fr.mastersid.toure.stackoverflow.data

data class ListQuestionJson(
    val items: List<QuestionJson>
)

data class QuestionJson(
    val question_id: Int,
    val title: String,
    val answer_count: Int
)