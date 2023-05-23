package com.example.chsb.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "products",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Brand::class,
            parentColumns = ["brandId"],
            childColumns = ["brandId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Product(
    @PrimaryKey(autoGenerate = true)
    val productId: Long = 0,
    val name: String,
    val description: String,
    val price: Double,
    val quantityInStock: Int,
    val categoryId: Int,
    val brandId: String,
    val imageUrl: String
)

