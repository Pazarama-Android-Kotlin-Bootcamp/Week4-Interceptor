package com.merttoptas.interceptorexample.data.api

import com.merttoptas.interceptorexample.BuildConfig
import com.merttoptas.interceptorexample.data.api.interceptor.AuthInterceptor
import com.merttoptas.interceptorexample.data.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by merttoptas on 9.10.2022.
 */
class ApiClient {
    companion object {
        private lateinit var apiService: ApiService

        fun getApiService(): ApiService {
            if (!::apiService.isInitialized) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient())
                    .build()

                apiService = retrofit.create(ApiService::class.java)
            }
            return apiService
        }

        private fun getHttpClient(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(AuthInterceptor())
            httpClient.connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
            httpClient.readTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
            httpClient.writeTimeout(90, java.util.concurrent.TimeUnit.SECONDS)
            return httpClient.build()
        }
    }
}