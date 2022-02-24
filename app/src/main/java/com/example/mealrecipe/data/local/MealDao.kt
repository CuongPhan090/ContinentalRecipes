package com.example.mealrecipe.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(meal: MealEntity)

    @Delete
    suspend fun deleteMeal(meal: MealEntity)

    @Query("SELECT * FROM meals")
    fun getAllMeals(): LiveData<List<MealEntity>>
}