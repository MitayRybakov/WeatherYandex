package com.example.weather.di

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-Yandex-API-Key", key)
            .build()
        return chain.proceed(request)
    }

    private companion object {
        const val key = "c53790e0-3eb0-4df6-a680-e36782dbfdd3"
    }
}