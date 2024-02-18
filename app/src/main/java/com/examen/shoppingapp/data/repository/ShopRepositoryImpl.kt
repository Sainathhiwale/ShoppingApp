package com.examen.shoppingapp.data.repository

import com.examen.shoppingapp.data.local.Entity.CartItem2
import com.examen.shoppingapp.data.local.Entity.ShopItem
import com.examen.shoppingapp.data.remote.model.Login
import com.examen.shoppingapp.data.remote.model.LoginResponse
import com.examen.shoppingapp.data.remote.model.User
import com.examen.shoppingapp.data.repository.datasource.ShopLocalDataSource
import com.examen.shoppingapp.data.repository.datasource.ShopRemoteDataSource
import com.examen.shoppingapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class ShopRepositoryImpl(
private val localDataSource: ShopLocalDataSource,
private val remoteDataSource: ShopRemoteDataSource
):ShopRepository {
    override suspend fun loginUser(login: Login): Resource<LoginResponse> {
      return responseToString(remoteDataSource.loginUser(login))
    }



    override suspend fun registerUser(user: User): Resource<User> {
        TODO("Not yet implemented")
    }

    override suspend fun addToCartItems(cartItem2: CartItem2) {
        TODO("Not yet implemented")
    }

    override fun getCartItems(): Flow<List<CartItem2>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateCartItems(cartItem2: CartItem2) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCartItems(cartItem2: CartItem2) {
        TODO("Not yet implemented")
    }

    override suspend fun clearCart() {
        TODO("Not yet implemented")
    }

    override suspend fun addToWishlist(shopItem: ShopItem) {
        TODO("Not yet implemented")
    }

    override fun getWishlistItems(): Flow<List<ShopItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWishlistItem(shopItem: ShopItem) {
        TODO("Not yet implemented")
    }

    override suspend fun clearWishlist() {
        TODO("Not yet implemented")
    }

    // receive the response to sealed class source  method
    //login response
    private fun responseToString(loginUserResponse: Response<LoginResponse>): Resource<LoginResponse> {
      if (loginUserResponse.isSuccessful){
        loginUserResponse.body()?.let {
          return Resource.Success(it)
        }
      }
        return Resource.Error(message = "${loginUserResponse.errorBody()?.string()}")
    }

}