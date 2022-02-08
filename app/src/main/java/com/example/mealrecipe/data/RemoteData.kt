package com.example.mealrecipe.data

import com.example.mealrecipe.model.Category
import com.example.mealrecipe.model.Meal
import com.example.mealrecipe.network.ApiClient
import javax.inject.Inject

interface RemoteData {
    suspend fun getCategory(): Category
    suspend fun getMeal(selectedCategory: String): Meal
}

class RemoteDataImpl @Inject constructor(private val remoteDatabase: ApiClient): RemoteData {

    override suspend fun getCategory() = remoteDatabase.getCategory()

    override suspend fun getMeal(selectedCategory: String) =
        remoteDatabase.getMeal(selectedCategory)
}