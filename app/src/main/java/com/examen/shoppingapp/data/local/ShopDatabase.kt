package com.examen.shoppingapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.examen.shoppingapp.data.local.Entity.CartItem2
import com.examen.shoppingapp.data.local.Entity.ShopItem

@Database(entities = [CartItem2::class, ShopItem::class], version = 3, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ShopDatabase : RoomDatabase() {
    abstract fun shopDao() : ShopDAO
}