package com.examen.shoppingapp.data.remote

import com.examen.shoppingapp.data.remote.model.Login
import com.examen.shoppingapp.data.remote.model.LoginResponse
import com.examen.shoppingapp.data.remote.model.Shop
import com.examen.shoppingapp.data.remote.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ShopApiService {
    //Login user
    @POST("auth/login")
    suspend fun loginUser(@Body login : Login): Response<LoginResponse>

    //Register user
    @POST("users")
    suspend fun registerUser(@Body user : User): Response<User>

    // Home - get all product
    @GET("/products")
    suspend fun getAllProducts() : Response<Shop>


}