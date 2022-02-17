package com.example.mealrecipe.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category(
    @Json(name = "categories")
    internal val _categories: List<CategoryDetail>
) {
    val categories: List<CategoryDetail> by lazy {
        _categories.filter { category -> category.isValid() }
    }
}

@JsonClass(generateAdapter = true)
data class CategoryDetail(
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