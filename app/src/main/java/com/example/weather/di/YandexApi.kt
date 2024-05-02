package com.example.weather.di

import com.example.weather.data.model.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface YandexApi {

    @GET("v2/forecast")
    suspend fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): WeatherDto
}