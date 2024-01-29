package fr.mastersid.toure.stackoverflow.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class QuestionsRepositoryModule {
    @Binds
    abstract fun bindQuestionsRepository(questionsRepository: QuestionsRepositoryImpl):
            QuestionsRepository
}