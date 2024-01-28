package fr.mastersid.toure.stackoverflow.webservice

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.mastersid.toure.stackoverflow.data.QuestionMoshiAdapter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL ="https://api.stackexchange.com/2.3/"

@Module
@InstallIn(SingletonComponent::class)
object QuestionWebServiceModule {


    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(QuestionMoshiAdapter())
            .build()
    }

    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideQuestionsWebService(retrofit: Retrofit): QuestionsWebService {
        return retrofit.create(QuestionsWebService::class.java)
    }
}