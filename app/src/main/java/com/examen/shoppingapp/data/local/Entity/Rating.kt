package com.examen.shoppingapp.data.local.Entity

import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("count")
    val count: Int,
    @SerializedName("rate")
    val rate: Double
)