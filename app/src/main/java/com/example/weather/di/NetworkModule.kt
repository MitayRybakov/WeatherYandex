package com.example.weather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun createYandexApi(okHttpClient: OkHttpClient): YandexApi =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.weather.yandex.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(YandexApi::class.java)

    @Provides
    fun crateOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .build()
}