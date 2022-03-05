package com.example.continentalrecipes.di.module

import android.content.Context
import androidx.room.Room
import com.example.continentalrecipes.BuildConfig
import com.example.continentalrecipes.data.local.MealDao
import com.example.continentalrecipes.data.local.MealDatabase
import com.example.continentalrecipes.data.remote.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    /**
     * Retrofit Dependencies
     */
    @Provides
    fun provideBaseUrl(): String = "https://www.themealdb.com/api/json/v1/1/"

    @Singleton
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
        } else {
            OkHttpClient.Builder().build()
        }

    @Singleton
    @Provides
    fun provideRetrofit(url: String, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideCategoryApi(retrofit: Retrofit): ApiClient = retrofit.create(ApiClient::class.java)

    /**
     * Room DB Dependencies
     */
    @Singleton
    @Provides
    fun provideMealDao(mealDatabase: MealDatabase): MealDao = mealDatabase.mealDao()

    @Singleton
    @Provides
    fun provideMealDatabase(@ApplicationContext context: Context): MealDatabase =
        Room.databaseBuilder(context, MealDatabase::class.java, "MealLocalDatabase").build()
}
