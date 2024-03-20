package com.examen.shoppingapp.data.repository

import com.examen.shoppingapp.data.local.Entity.CartItem2
import com.examen.shoppingapp.data.local.Entity.ShopItem
import com.examen.shoppingapp.data.remote.model.Category
import com.examen.shoppingapp.data.remote.model.Login
import com.examen.shoppingapp.data.remote.model.LoginResponse
import com.examen.shoppingapp.data.remote.model.Shop
import com.examen.shoppingapp.data.remote.model.User
import com.examen.shoppingapp.data.repository.datasource.ShopLocalDataSource
import com.examen.shoppingapp.data.repository.datasource.ShopRemoteDataSource
import com.examen.shoppingapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val remoteDataSource: ShopRemoteDataSource,
    private val localDataSource: ShopLocalDataSource
):ShopRepository {
    // login api call
    override suspend fun loginUser(login: Login): Resource<LoginResponse> {
      return responseToString(remoteDataSource.loginUser(login))
    }
    // sign up api call
    override suspend fun registerUser(user: User): Resource<User> {
        return responseToUserResult(remoteDataSource.registerUser(user))
    }
    // get all product api call
    override suspend fun getAllProducts(): Resource<Shop> {
     return responseToShopResult(remoteDataSource.getAllProduct())
    }
    // get all product categories
    override suspend fun getAllCategories(): Resource<Category> {
       return responseToCategoryResult(remoteDataSource.getAllCategories())
    }

    private fun responseToCategoryResult(response: Response<Category>) : Resource<Category>{
        if (response.isSuccessful){
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }

    override suspend fun getCategoryProducts(category: String): Resource<Shop> {
        TODO("Not yet implemented")
    }



    //local db operation
    override suspend fun addToCartItems(cartItem2: CartItem2) {

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

    // register the user

    private fun responseToUserResult(response : Response<User>) : Resource<User>{
        if (response.isSuccessful){
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }
    // get all product call function

    private fun responseToShopResult(allProductResponse: Response<Shop>): Resource<Shop> {
        if (allProductResponse.isSuccessful){
            allProductResponse.body()?.let {  shop ->
                return Resource.Success(shop)
            }
        }
        return Resource.Error(message =  "${allProductResponse.errorBody()?.toString()}")
    }

}