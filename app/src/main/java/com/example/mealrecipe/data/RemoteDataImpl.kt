package com.example.mealrecipe.data

import com.example.mealrecipe.model.Category
import com.example.mealrecipe.model.Meal
import com.example.mealrecipe.network.ApiService

interface RemoteData {
    suspend fun getCategory(): Category
    suspend fun getMeal(selectedCategory: String): Meal
}

class RemoteDataImpl: RemoteData {
    private val remoteDatabase = ApiService.categoryApi

    override suspend fun getCategory() = remoteDatabase.getCategory()

    override suspend fun getMeal(selectedCategory: String) =
        remoteDatabase.getMeal(selectedCategory)
}