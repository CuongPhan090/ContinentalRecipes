package com.example.mealrecipe.repository

import com.example.mealrecipe.network.ApiService

class MealRepository {
    private val remoteDatabase = ApiService.categoryApi

    suspend fun getCategory() = remoteDatabase.getCategory()

//    suspend fun getMeal() = remoteDatabase.getMeal()
}