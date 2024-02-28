package com.examen.shoppingapp.data.di

import com.examen.shoppingapp.data.local.ShopDAO
import com.examen.shoppingapp.data.remote.ShopApiService
import com.examen.shoppingapp.data.repository.datasource.ShopLocalDataSource
import com.examen.shoppingapp.data.repository.datasource.ShopRemoteDataSource
import com.examen.shoppingapp.data.repository.datasourceImpl.ShopLocalDataSourceImpl
import com.examen.shoppingapp.data.repository.datasourceImpl.ShopRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(shopDAO: ShopDAO) : ShopLocalDataSource {
        return ShopLocalDataSourceImpl(shopDAO)
    }

    @Singleton
    @Provides
    fun provideShopRemoteDataSource(shopApiService: ShopApiService) : ShopRemoteDataSource {
        return ShopRemoteDataSourceImpl(shopApiService)
    }

}