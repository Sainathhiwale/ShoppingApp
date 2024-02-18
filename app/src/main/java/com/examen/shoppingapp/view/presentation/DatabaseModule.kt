package com.examen.shoppingapp.view.presentation

import android.app.Application
import androidx.room.Room
import com.examen.shoppingapp.data.local.Converters
import com.examen.shoppingapp.data.local.ShopDAO
import com.examen.shoppingapp.data.local.ShopDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesShopDatabase(app : Application, gson : Gson) : ShopDatabase{
        return Room.databaseBuilder(app, ShopDatabase::class.java,"shop_database")
            .fallbackToDestructiveMigration()
            .addTypeConverter(Converters(gson))
            .build()
    }

    @Singleton
    @Provides
    fun providesShopDao(database: ShopDatabase) : ShopDAO {
        return database.shopDao()
    }

}