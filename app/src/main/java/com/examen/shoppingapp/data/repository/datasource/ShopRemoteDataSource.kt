package com.examen.shoppingapp.data.repository.datasource

import com.examen.shoppingapp.data.remote.model.Login
import com.examen.shoppingapp.data.remote.model.LoginResponse
import com.examen.shoppingapp.data.remote.model.User
import retrofit2.Response

interface ShopRemoteDataSource {

    suspend fun loginUser(login : Login): Response<LoginResponse>

    suspend fun registerUser(user: User) : Response<User>
}