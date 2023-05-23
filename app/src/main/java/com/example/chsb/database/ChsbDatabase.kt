package com.example.chsb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chsb.database.dao.BrandDao
import com.example.chsb.database.dao.CartDao
import com.example.chsb.database.dao.CategoryDao
import com.example.chsb.database.dao.OrderDao
import com.example.chsb.database.dao.OrderItemDao
import com.example.chsb.database.dao.ProductDao
import com.example.chsb.database.dao.UserDao
import com.example.chsb.database.entity.Brand
import com.example.chsb.database.entity.Cart
import com.example.chsb.database.entity.Category
import com.example.chsb.database.entity.Order
import com.example.chsb.database.entity.OrderItem
import com.example.chsb.database.entity.Product
import com.example.chsb.database.entity.User

@Database(entities = [User::class, Product::class, Order::class, OrderItem::class, Category::class, Brand::class, Cart::class], version = 1)
abstract class ChsbDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao
    abstract fun orderDao(): OrderDao
    abstract fun orderItemDao(): OrderItemDao
    abstract fun categoryDao(): CategoryDao
    abstract fun brandDao(): BrandDao
    abstract fun cartDao(): CartDao

    companion object {
        private var instance: ChsbDatabase? = null

        @Synchronized
        fun getInstance(context: Context): ChsbDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChsbDatabase::class.java,
                    "chsb_database"
                ).build()
            }
            return instance as ChsbDatabase
        }
    }
}
