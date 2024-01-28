package fr.mastersid.toure.stackoverflow.webservice

import fr.mastersid.toure.stackoverflow.data.ListQuestionJson
import fr.mastersid.toure.stackoverflow.ui.Question
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionsWebService {
    @GET("questions")
    suspend fun getQuestionsList(
        @Query("pagesize") pagesize: Int = 20,
        @Query("order") order: String = "desc",
        @Query("sort") sort: String = "activity",
        @Query("site") site: String = "stackoverflow"
    ): List<Question>
}