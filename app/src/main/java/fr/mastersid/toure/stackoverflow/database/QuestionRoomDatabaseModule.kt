package fr.mastersid.toure.stackoverflow.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object QuestionRoomDatabaseModule {
    @Provides
    fun provideQuestionDao(weatherRoomDatabase: QuestionRoomDataBase): QuestionDao {
        return weatherRoomDatabase.questionDao()
    }

   @Provides
   @Singleton

   fun provideQuestionRoomDatabase(@ApplicationContext appContext : Context):
           QuestionRoomDataBase {
       return Room.databaseBuilder(
           appContext.applicationContext,
           QuestionRoomDataBase::class.java,
           "question_database"
       ).build()
   }

}