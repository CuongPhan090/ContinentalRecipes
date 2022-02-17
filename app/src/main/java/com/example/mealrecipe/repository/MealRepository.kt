package com.example.mealrecipe.repository

import com.example.mealrecipe.data.RemoteDataImpl
import com.example.mealrecipe.model.Category
import com.example.mealrecipe.model.Meal
import com.example.mealrecipe.model.Recipe
import dagger.hilt.android.scopes.ViewModelScoped
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

interface MealRepository {
    suspend fun getCategories(): Category
    suspend fun getMeals(selectedCategory: String): Meal
    suspend fun getRecipe(selectedMeal: String): Recipe

    fun putSelectedCategory(selectedCategory: String)
    fun putSelectedMeal(selectedMeal: String)
    fun putFavoriteMeal(selectedMeal: Meal)
    fun getSelectedCategory(): String
    fun getSelectedMeal(): String
    fun getFavoriteMeal(): List<Meal>
    fun removeFavoriteMeal(selectedMeal: Meal)
}

@Singleton
class MealRepositoryImpl @Inject constructor (private val remoteDataImpl: RemoteDataImpl) : MealRepository {
    private val itemStack: Stack<String> = Stack()
    private val favoriteMeals = mutableListOf<Meal>()

    override suspend fun getCategories(): Category = remoteDataImpl.getCategory()

    override suspend fun getMeals(selectedCategory: String): Meal =
        remoteDataImpl.getMeal(selectedCategory)

    override suspend fun getRecipe(selectedMeal: String): Recipe =
        remoteDataImpl.getRecipe(selectedMeal)

    override fun putSelectedCategory(selectedCategory: String) {
        itemStack.push(selectedCategory)
    }

    override fun putSelectedMeal(selectedMeal: String) {
        itemStack.push(selectedMeal)
    }

    override fun putFavoriteMeal(selectedMeal: Meal) {
        favoriteMeals.add(selectedMeal)
    }

    override fun getSelectedMeal(): String {
        if (itemStack.isEmpty()) {
            return ""
        }
        return itemStack.pop()
    }

    override fun getSelectedCategory(): String {
        if (itemStack.isEmpty()) {
            return ""
        }
        return itemStack.pop()
    }

    override fun getFavoriteMeal(): List<Meal> {
        return favoriteMeals
    }

    override fun removeFavoriteMeal(selectedMeal: Meal) {
        favoriteMeals.remove(selectedMeal)
    }
}
