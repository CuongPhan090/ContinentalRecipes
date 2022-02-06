package com.example.mealrecipe.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Category(
    val categories: List<CategoryDetail>
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class CategoryDetail(
    @Json(name="idCategory")
    val id: String,
    @Json(name="strCategory")
    val category: String,
    @Json(name="strCategoryThumb")
    val categoryThumb: String
) : Parcelable
