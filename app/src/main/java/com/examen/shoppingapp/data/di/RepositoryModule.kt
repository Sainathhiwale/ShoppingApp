package com.examen.shoppingapp.data.di

import com.examen.shoppingapp.data.repository.ShopRepository
import com.examen.shoppingapp.data.repository.ShopRepositoryImpl
import com.examen.shoppingapp.data.repository.datasource.ShopLocalDataSource
import com.examen.shoppingapp.data.repository.datasource.ShopRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesShopRepository(shopRemoteDataSource: ShopRemoteDataSource, localDataSource: ShopLocalDataSource) : ShopRepository {
        return ShopRepositoryImpl(shopRemoteDataSource,localDataSource)
    }

}