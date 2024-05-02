package com.example.weather.data.dataSource.mapper

import com.example.weather.data.model.WeatherDto
import com.example.weather.domain.model.Weather
import javax.inject.Inject

class WeatherMapper @Inject constructor() {
    fun mapToModel(dto: WeatherDto): Weather = Weather(dto.fact.temp)
}