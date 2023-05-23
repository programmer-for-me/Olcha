package com.example.chsb.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "brands")
data class Brand(
    @PrimaryKey(autoGenerate = true)
    val brandId: Int = 0,
    val brandName: String
)

