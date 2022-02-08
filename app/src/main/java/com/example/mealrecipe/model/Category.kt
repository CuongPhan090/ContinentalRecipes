package com.example.mealrecipe.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    val categories: List<CategoryDetail>
)

@JsonClass(generateAdapter = true)
data class CategoryDetail(
    @Json(name="idCategory")
    val id: String,
    @Json(name="strCategory")
    val category: String,
    @Json(name="strCategoryThumb")
    val categoryThumb: String
)