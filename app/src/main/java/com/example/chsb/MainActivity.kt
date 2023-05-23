package com.example.chsb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.chsb.database.ChsbDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val database = Room.databaseBuilder(applicationContext, ChsbDatabase::class.java, "chsb_database").build()
    }
}