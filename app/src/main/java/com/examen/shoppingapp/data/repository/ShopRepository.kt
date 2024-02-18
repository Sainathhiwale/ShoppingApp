package com.examen.shoppingapp.data.repository

import com.examen.shoppingapp.data.local.Entity.CartItem2
import com.examen.shoppingapp.data.local.Entity.ShopItem
import com.examen.shoppingapp.data.remote.model.Login
import com.examen.shoppingapp.data.remote.model.LoginResponse
import com.examen.shoppingapp.data.remote.model.User
import com.examen.shoppingapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ShopRepository {
    //remote
    suspend fun loginUser(login: Login) : Resource<LoginResponse>
    suspend fun registerUser(user : User) : Resource<User>

    //local
    suspend fun addToCartItems(cartItem2: CartItem2)
    fun getCartItems() : Flow<List<CartItem2>>
    suspend fun updateCartItems(cartItem2: CartItem2)
    suspend fun deleteCartItems(cartItem2: CartItem2)
    suspend fun clearCart()

    suspend fun addToWishlist(shopItem: ShopItem)
    fun getWishlistItems() : Flow<List<ShopItem>>
    suspend fun deleteWishlistItem(shopItem: ShopItem)
    suspend fun clearWishlist()
}