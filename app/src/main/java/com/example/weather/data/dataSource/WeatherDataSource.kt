package com.example.weather.data.dataSource

import com.example.weather.data.model.WeatherDto
import com.example.weather.di.YandexApi
import javax.inject.Inject

class WeatherDataSource @Inject constructor(
    private val api: YandexApi,
) {

    suspend fun get(lat: String, lon: String): WeatherDto =
        api.getWeather(lat, lon)
}
