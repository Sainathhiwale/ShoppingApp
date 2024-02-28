package com.examen.shoppingapp.data.di

import com.examen.shoppingapp.data.domain.AuthUseCase
import com.examen.shoppingapp.data.local.sharedpref.SharedPreferenceHelper
import com.examen.shoppingapp.viewmodel.LoginViewModel
import com.examen.shoppingapp.viewmodel.RegisterViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule {

    @Singleton
    @Provides
    fun providesLoginViewModel(authUseCase: AuthUseCase, sharedPreference: SharedPreferenceHelper) : LoginViewModel{
        return LoginViewModel(authUseCase,sharedPreference)
    }

    @Singleton
    @Provides
    fun providesRegisterViewModel(authUseCase: AuthUseCase, sharedPreference: SharedPreferenceHelper): RegisterViewModel {
        return RegisterViewModel(authUseCase, sharedPreference)
    }
}