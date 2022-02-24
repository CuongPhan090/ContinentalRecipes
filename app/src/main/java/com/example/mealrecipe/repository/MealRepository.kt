package com.example.mealrecipe.repository

import androidx.lifecycle.LiveData
import com.example.mealrecipe.data.remote.RemoteDataImpl
import com.example.mealrecipe.data.local.LocalDataImpl
import com.example.mealrecipe.data.local.MealEntity
import com.example.mealrecipe.model.Categories
import com.example.mealrecipe.model.Meals
import com.example.mealrecipe.model.Recipes
import javax.inject.Inject
import javax.inject.Singleton

interface MealRepository {
    suspend fun getCategories(): Categories
    suspend fun getMeals(selectedCategory: String): Meals
    suspend fun getRecipe(selectedMeal: String): Recipes

    fun putSelectedCategoryName(selectedCategoryName: String)
    fun getSelectedCategoryName(): String

    fun putSelectedMealName(selectedMealName: String)
    fun getSelectedMealName(): String

    suspend fun putFavoriteMeal(selectedMeal: MealEntity)
    fun getFavoriteMeals(): LiveData<List<MealEntity>>
    suspend fun deleteFavoriteMeal(selectedMeal: MealEntity)
}

@Singleton
class MealRepositoryImpl @Inject constructor(
    private val remoteDataImpl: RemoteDataImpl,
    private val localDataImpl: LocalDataImpl
) : MealRepository {
    private val itemClickedMap = mutableMapOf<String, String>()

    override suspend fun getCategories(): Categories = remoteDataImpl.getCategory()

    override suspend fun getMeals(selectedCategory: String): Meals =
        remoteDataImpl.getMeal(selectedCategory)

    override suspend fun getRecipe(selectedMeal: String): Recipes =
        remoteDataImpl.getRecipe(selectedMeal)

    override fun putSelectedCategoryName(selectedCategoryName: String) {
        itemClickedMap["selectedCategoryName"] = selectedCategoryName
    }

    override fun getSelectedCategoryName(): String =
        itemClickedMap.getOrDefault("selectedCategoryName", "")

    override fun putSelectedMealName(selectedMealName: String) {
        itemClickedMap["selectedMealName"] = selectedMealName
    }

    override fun getSelectedMealName(): String = itemClickedMap.getOrDefault("selectedMealName", "")

    override suspend fun putFavoriteMeal(selectedMeal: MealEntity) {
        localDataImpl.insertMeal(selectedMeal)
    }

    override fun getFavoriteMeals(): LiveData<List<MealEntity>> {
        return localDataImpl.getAllMeals()
    }

    override suspend fun deleteFavoriteMeal(selectedMeal: MealEntity) {
        localDataImpl.deleteMeal(selectedMeal)
    }
}
