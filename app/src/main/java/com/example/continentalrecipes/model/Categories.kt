package com.example.continentalrecipes.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Categories(
    @Json(name = "categories")
    internal val _categories: List<Category>
) {
    val categories: List<Category> by lazy {
        _categories.filter { category -> category.isValid() }
    }
}

@JsonClass(generateAdapter = true)
data class Category(
    @Json(name="idCategory")
    val id: String,
    @Json(name="strCategory")
    val category: String,
    @Json(name="strCategoryThumb")
    val categoryThumb: String
) {
    fun isValid(): Boolean {
        return id.isNotBlank() && category.isNotBlank() && categoryThumb.isNotBlank()
    }
}