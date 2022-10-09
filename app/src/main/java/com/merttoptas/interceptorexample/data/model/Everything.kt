package com.merttoptas.interceptorexample.data.model


import com.google.gson.annotations.SerializedName

data class Everything(
    @SerializedName("articles")
    val articles: List<Article?>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
)