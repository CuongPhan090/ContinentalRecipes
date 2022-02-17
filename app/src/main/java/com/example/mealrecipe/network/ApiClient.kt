package com.example.mealrecipe.network

import com.example.mealrecipe.model.Category
import com.example.mealrecipe.model.Meal
import com.example.mealrecipe.model.Recipe
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiClient {

    @GET("categories.php")
    suspend fun getCategories(): Category

    @POST("filter.php")
    suspend fun getMeal(@Query("c") c: String): Meal

    @POST("search.php")
    suspend fun getRecipe(@Query("s") s: String): Recipe
}
