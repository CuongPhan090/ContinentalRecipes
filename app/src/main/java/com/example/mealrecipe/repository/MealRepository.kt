package com.example.mealrecipe.repository

import com.example.mealrecipe.data.RemoteDataImpl
import com.example.mealrecipe.model.Category
import com.example.mealrecipe.model.Meal
import dagger.hilt.android.scopes.ViewModelScoped
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

interface MealRepository {
    suspend fun getCategories(): Category
    suspend fun getMeals(selectedCategory: String): Meal
    suspend fun getRecipe()

    fun putSelectedCategory(selectedCategory: String)
    fun getSelectedCategory(): String
    fun putSelectedMeal(selectedMeal: String)
    fun getSelectedMeal(): String
}

@Singleton
class MealRepositoryImpl @Inject constructor (private val remoteDataImpl: RemoteDataImpl) : MealRepository {
    private val itemStack: Stack<String> = Stack()
    override suspend fun getCategories(): Category = remoteDataImpl.getCategory()

    override suspend fun getMeals(selectedCategory: String): Meal =
        remoteDataImpl.getMeal(selectedCategory)

    override suspend fun getRecipe() {
        TODO("Not yet implemented")
    }

    override fun putSelectedCategory(selectedCategory: String) {
        itemStack.push(selectedCategory)
    }

    override fun getSelectedCategory(): String {
        if (itemStack.isEmpty()) {
            return ""
        }
        return itemStack.pop()
    }

    override fun putSelectedMeal(selectedMeal: String) {
        itemStack.push(selectedMeal)
    }

    override fun getSelectedMeal(): String {
        if (itemStack.isEmpty()) {
            return ""
        }
        return itemStack.pop()
    }
}

