package com.example.mealrecipe.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meals")
data class MealEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "mealId")
    var id: Int,

    @ColumnInfo(name = "thumb")
    val mealThumb: String,

    @ColumnInfo(name = "title")
    val meal: String
)
