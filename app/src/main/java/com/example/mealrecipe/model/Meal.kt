package com.example.mealrecipe.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meal(
    val meals: List<MealDetail>
)

@JsonClass(generateAdapter = true)
data class MealDetail(
    @Json(name = "idMeal")
    val id: String,
    @Json(name = "strMeal")
    val meal: String,
    @Json(name = "strMealThumb")
    val mealThumb: String
)