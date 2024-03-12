package com.examen.shoppingapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.examen.shoppingapp.data.domain.ProductUseCase
import com.examen.shoppingapp.data.remote.model.Category
import com.examen.shoppingapp.data.remote.model.Shop
import com.examen.shoppingapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app : Application,
    private val productUseCase: ProductUseCase
) : ViewModel (){

    val products : MutableLiveData<Resource<Shop>> = MutableLiveData()
    val categories : MutableLiveData<Resource<Category>> = MutableLiveData()

    fun getAllCategories()={

    }
}