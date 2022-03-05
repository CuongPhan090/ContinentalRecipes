package com.example.continentalrecipes.data.local

import androidx.lifecycle.LiveData
import javax.inject.Inject

interface LocalData {
    suspend fun insertMeal(meal: MealEntity)
    suspend fun deleteMeal(meal: MealEntity)
    fun getAllMeals(): LiveData<List<MealEntity>>
}
class LocalDataImpl @Inject constructor (private val mealDao: MealDao): LocalData{
    override suspend fun insertMeal(meal: MealEntity) {
        mealDao.insertMeal(meal)
    }

    override suspend fun deleteMeal(meal: MealEntity) {
        mealDao.deleteMeal(meal)
    }

    override fun getAllMeals(): LiveData<List<MealEntity>> {
        return mealDao.getAllMeals()
    }
}

