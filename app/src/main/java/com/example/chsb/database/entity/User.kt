package com.example.chsb.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
    val username: String,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val address: String,
    val phoneNumber: String,
    val paymentInfo: String
)
