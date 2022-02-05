package com.example.mealrecipe.network

import com.example.mealrecipe.model.Category
import retrofit2.http.GET

interface ApiClient {

    @GET("categories.php")
    suspend fun getCategory(): Category
}
