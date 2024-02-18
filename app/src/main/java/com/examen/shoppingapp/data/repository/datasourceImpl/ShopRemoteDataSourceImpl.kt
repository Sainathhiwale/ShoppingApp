package com.examen.shoppingapp.data.repository.datasourceImpl

import com.examen.shoppingapp.data.repository.datasource.ShopRemoteDataSource
import com.examen.shoppingapp.data.remote.ShopApiService
import com.examen.shoppingapp.data.remote.model.Login
import com.examen.shoppingapp.data.remote.model.LoginResponse
import com.examen.shoppingapp.data.remote.model.User
import retrofit2.Response
import javax.inject.Inject

class ShopRemoteDataSourceImpl @Inject constructor( private val apiService: ShopApiService): ShopRemoteDataSource {

    override suspend fun loginUser(login: Login): Response<LoginResponse> {
     return apiService.loginUser(login)
    }

    override suspend fun registerUser(user: User): Response<User> {
       return apiService.registerUser(user)
    }
}