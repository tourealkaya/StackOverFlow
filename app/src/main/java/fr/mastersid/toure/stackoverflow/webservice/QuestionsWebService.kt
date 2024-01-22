package fr.mastersid.toure.stackoverflow.webservice

import fr.mastersid.toure.stackoverflow.data.ListQuestionJson
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionsWebService {
    @GET("questions?pagesize=20")
    fun getQuestionsList(
        @Query("order") order: String = "desc",
        @Query("sort") sort: String = "activity",
        @Query("site") site: String = "stackoverflow"
    ): ListQuestionJson
}