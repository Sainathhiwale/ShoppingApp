package com.examen.shoppingapp.data.domain

import com.examen.shoppingapp.data.remote.model.Category
import com.examen.shoppingapp.data.remote.model.Shop
import com.examen.shoppingapp.data.repository.ShopRepository
import com.examen.shoppingapp.utils.Resource
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val repository: ShopRepository
) {
    suspend fun getAllProducts() : Resource<Shop> {
        return repository.getAllProducts()
    }

    suspend fun getAllCategories() : Resource<Category>{
        return repository.getAllCategories()
    }

    suspend fun getCategoryProducts(category : String) : Resource<Shop>{
        return repository.getCategoryProducts(category)
    }
}