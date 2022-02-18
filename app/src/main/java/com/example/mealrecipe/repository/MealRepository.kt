package com.example.mealrecipe.repository

import com.example.mealrecipe.data.RemoteDataImpl
import com.example.mealrecipe.model.Category
import com.example.mealrecipe.model.Meal
import com.example.mealrecipe.model.MealDetail
import com.example.mealrecipe.model.Recipe
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

interface MealRepository {
    suspend fun getCategories(): Category
    suspend fun getMeals(selectedCategory: String): Meal
    suspend fun getRecipe(selectedMeal: String): Recipe

    fun putSelectedCategoryName(selectedCategoryName: String)
    fun getSelectedCategoryName(): String

    fun putSelectedMealName(selectedMealName: String)
    fun getSelectedMealName(): String

    fun putFavoriteMeal(selectedMeal: MealDetail)
    fun getFavoriteMeals(): List<MealDetail>
    fun removeFavoriteMeal(selectedMeal: MealDetail)
}

@Singleton
class MealRepositoryImpl @Inject constructor (private val remoteDataImpl: RemoteDataImpl) : MealRepository {
    // favorite meal will be saved in ROOM
    private val favoriteMeals = mutableListOf<MealDetail>()

    private val itemClickedMap = mutableMapOf<String, String>()

    override suspend fun getCategories(): Category = remoteDataImpl.getCategory()

    override suspend fun getMeals(selectedCategory: String): Meal =
        remoteDataImpl.getMeal(selectedCategory)

    override suspend fun getRecipe(selectedMeal: String): Recipe =
        remoteDataImpl.getRecipe(selectedMeal)

    override fun putSelectedCategoryName(selectedCategoryName: String) {
        itemClickedMap["selectedCategoryName"] = selectedCategoryName
    }
    override fun getSelectedCategoryName(): String = itemClickedMap.getOrDefault("selectedCategoryName", "")

    override fun putSelectedMealName(selectedMealName: String) {
        itemClickedMap["selectedMealName"] = selectedMealName
    }
    override fun getSelectedMealName(): String = itemClickedMap.getOrDefault("selectedMealName", "")

    // favorite meal will be saved in ROOM
    override fun putFavoriteMeal(selectedMeal: MealDetail) {
        favoriteMeals.add(selectedMeal)
    }

    override fun getFavoriteMeals(): List<MealDetail> {
        return favoriteMeals
    }

    override fun removeFavoriteMeal(selectedMeal: MealDetail) {
        favoriteMeals.remove(selectedMeal)
    }
}
