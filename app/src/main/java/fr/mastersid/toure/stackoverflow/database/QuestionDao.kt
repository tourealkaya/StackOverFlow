package fr.mastersid.toure.stackoverflow.database
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.mastersid.toure.stackoverflow.ui.Question
import kotlinx.coroutines.flow.Flow
@Dao

interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Question>)
    @Query("SELECT * FROM question_table ORDER BY answerCount")
    fun getQuestionListFlow(): Flow<List<Question>>
}