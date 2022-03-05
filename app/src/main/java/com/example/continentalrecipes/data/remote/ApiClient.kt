package com.example.continentalrecipes.data.remote

import com.example.continentalrecipes.model.Categories
import com.example.continentalrecipes.model.Meals
import com.example.continentalrecipes.model.Recipes
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiClient {

    @GET("categories.php")
    suspend fun getCategories(): Categories

    @POST("filter.php")
    suspend fun getMeal(@Query("c") c: String): Meals

    @POST("search.php")
    suspend fun getRecipe(@Query("s") s: String): Recipes
}
