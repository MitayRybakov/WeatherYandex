package com.example.weather.data.repository

import com.example.weather.data.dataSource.WeatherDataSource
import com.example.weather.data.dataSource.mapper.WeatherMapper
import com.example.weather.domain.model.Weather
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherDataSource: WeatherDataSource,
    private val weatherMapper: WeatherMapper
) {

    suspend fun get(lat: String, lon: String): Weather {
        val dto = weatherDataSource.get(lat, lon)

        return weatherMapper.mapToModel(dto)
    }
}