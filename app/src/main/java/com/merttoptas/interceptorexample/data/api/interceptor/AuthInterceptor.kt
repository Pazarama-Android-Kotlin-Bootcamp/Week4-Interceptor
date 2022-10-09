package com.merttoptas.interceptorexample.data.api.interceptor

import com.merttoptas.interceptorexample.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by merttoptas on 9.10.2022.
 */

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val apiKeyRequest = originalRequest
            .newBuilder()
            .header("X-Api-Key", BuildConfig.API_KEY)
            .build()

        return chain.proceed(apiKeyRequest)
    }
}