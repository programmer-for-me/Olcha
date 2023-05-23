package com.example.chsb.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chsb.database.entity.Brand
import com.example.chsb.database.entity.Cart
import com.example.chsb.database.entity.Category
import com.example.chsb.database.entity.Order
import com.example.chsb.database.entity.OrderItem
import com.example.chsb.database.entity.Product
import com.example.chsb.database.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>

    @Query("SELECT * FROM users WHERE userId = :userId")
    suspend fun getUserById(userId: Long): User?

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun getUserByUsernameAndPassword(username: String, password: String): User?

    @Query("SELECT COUNT(*) FROM users")
    suspend fun getUserCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}


@Dao
interface ProductDao {
    @Query("SELECT * FROM products")
    suspend fun getAllProducts(): List<Product>

    @Query("SELECT * FROM products WHERE productId = :productId")
    suspend fun getProductById(productId: Long): Product?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)
}

@Dao
interface OrderDao {
    @Query("SELECT * FROM orders")
    suspend fun getAllOrders(): List<Order>

    @Query("SELECT * FROM orders WHERE orderId = :orderId")
    suspend fun getOrderById(orderId: Long): Order?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: Order)

    @Delete
    suspend fun deleteOrder(order: Order)
}


@Dao
interface OrderItemDao {
    @Query("SELECT * FROM order_items")
    suspend fun getAllOrderItems(): List<OrderItem>

    @Query("SELECT * FROM order_items WHERE orderItemId = :orderItemId")
    suspend fun getOrderItemById(orderItemId: Long): OrderItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderItem(orderItem: OrderItem)

    @Delete
    suspend fun deleteOrderItem(orderItem: OrderItem)
}

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<Category>

    @Query("SELECT * FROM categories WHERE categoryId = :categoryId")
    suspend fun getCategoryById(categoryId: Long): Category?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)
}

@Dao
interface BrandDao {
    @Query("SELECT * FROM brands")
    suspend fun getAllBrands(): List<Brand>

    @Query("SELECT * FROM brands WHERE brandId = :brandId")
    suspend fun getBrandById(brandId: Long): Brand?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBrand(brand: Brand)

    @Delete
    suspend fun deleteBrand(brand: Brand)
}

@Dao
interface CartDao {
    @Query("SELECT * FROM carts WHERE userId = :userId")
    suspend fun getCartsByUser(userId: Long): List<Cart>

    @Query("SELECT * FROM carts WHERE userId = :userId AND productId = :productId")
    suspend fun getCartByUserAndProduct(userId: Long, productId: Long): Cart?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCart(cart: Cart)

    @Delete
    suspend fun deleteCart(cart: Cart)
}

