package com.examen.shoppingapp.data.di

import com.examen.shoppingapp.data.domain.AuthUseCase
import com.examen.shoppingapp.data.repository.ShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun providesAuthUseCase(repository: ShopRepository) : AuthUseCase{
        return AuthUseCase(repository)
    }
    

}