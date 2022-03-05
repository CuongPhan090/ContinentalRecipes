package com.example.continentalrecipes.data.remote

import com.example.continentalrecipes.model.Categories
import com.example.continentalrecipes.model.Meals
import com.example.continentalrecipes.model.Recipes
import javax.inject.Inject

interface RemoteData {
    suspend fun getCategory(): Categories
    suspend fun getMeal(selectedCategory: String): Meals
    suspend fun getRecipe(selectedMeal: String): Recipes
}

class RemoteDataImpl @Inject constructor(private val remoteDatabase: ApiClient): RemoteData {

    override suspend fun getCategory() = remoteDatabase.getCategories()

    override suspend fun getMeal(selectedCategory: String) =
        remoteDatabase.getMeal(selectedCategory)

    override suspend fun getRecipe(selectedMeal: String): Recipes =
        remoteDatabase.getRecipe(selectedMeal)
}
