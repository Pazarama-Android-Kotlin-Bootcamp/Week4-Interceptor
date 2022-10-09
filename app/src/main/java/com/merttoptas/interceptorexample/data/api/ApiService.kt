package com.merttoptas.interceptorexample.data.api

import com.merttoptas.interceptorexample.data.model.Everything
import com.merttoptas.interceptorexample.data.utils.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by merttoptas on 9.10.2022.
 */

interface ApiService {
    @GET(Constants.EVERYTHING)
    fun getEverythingNews(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String
    ): Call<Everything>
}