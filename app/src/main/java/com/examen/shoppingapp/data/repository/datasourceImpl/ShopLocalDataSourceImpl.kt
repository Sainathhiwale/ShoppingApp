package com.examen.shoppingapp.data.repository.datasourceImpl

import com.examen.shoppingapp.data.repository.datasource.ShopLocalDataSource
import com.examen.shoppingapp.data.local.Entity.CartItem2
import com.examen.shoppingapp.data.local.Entity.ShopItem
import com.examen.shoppingapp.data.local.ShopDAO
import kotlinx.coroutines.flow.Flow

class ShopLocalDataSourceImpl(private val shopDAO: ShopDAO): ShopLocalDataSource {

    override suspend fun addToCart(cartItem2: CartItem2) {
        return shopDAO.addToCart(cartItem2)
    }

    override fun getCartItems(): Flow<List<CartItem2>> {
       return shopDAO.cartItems()
    }

    override suspend fun updateCartItems(cartItem2: CartItem2) {
        return shopDAO.updateCart(cartItem2)
    }

    override suspend fun deleteCartItems(cartItem2: CartItem2) {
        return shopDAO.deleteCart(cartItem2)
    }

    override suspend fun clearCart() {
        return shopDAO.clearAll()
    }

    override suspend fun addToWishlist(shopItem: ShopItem) {
        return shopDAO.addToWishlist(shopItem)
    }

    override fun getWishlistItems(): Flow<List<ShopItem>> {
        return shopDAO.wishlistItems()
    }

    override suspend fun deleteWishlistItem(shopItem: ShopItem) {
        return shopDAO.deleteWishlist(shopItem)
    }

    override suspend fun clearWishlist() {
       return shopDAO.clearWishlist()
    }
}