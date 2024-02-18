package com.examen.shoppingapp.view.presentation

import com.examen.shoppingapp.data.domain.AuthUseCase
import com.examen.shoppingapp.data.local.sharedpref.SharedPreferenceHelper
import com.examen.shoppingapp.viewmodel.LoginViewModel
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
}