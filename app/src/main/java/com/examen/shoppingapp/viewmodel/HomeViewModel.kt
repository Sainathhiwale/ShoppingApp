package com.examen.shoppingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examen.shoppingapp.data.domain.ProductUseCase
import com.examen.shoppingapp.data.remote.model.Category
import com.examen.shoppingapp.data.remote.model.Shop
import com.examen.shoppingapp.utils.NetworkUtils.isNetworkAvailable
import com.examen.shoppingapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val app : Application,
    private val productUseCase: ProductUseCase
) : AndroidViewModel (app){

    val products : MutableLiveData<Resource<Shop>> = MutableLiveData()
    val categories : MutableLiveData<Resource<Category>> = MutableLiveData()

    fun getAllProducts()= viewModelScope.launch(IO){
     products.postValue(Resource.Loading())
      try {
         if (isNetworkAvailable(app)){
             val apiResult = productUseCase.getAllProducts()
             products.postValue(apiResult)
         }else{
             products.postValue(Resource.Error(message = "Internet not available"))

         }
      }catch (e:Exception){
          products.postValue(Resource.Error(message = e.localizedMessage ?: "Unknown Error"))
      }
    }

}