package com.example.weather.domain.useCase

import com.example.weather.data.repository.WeatherRepository
import com.example.weather.domain.model.City
import com.example.weather.domain.model.Weather
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository,
) {

    suspend operator fun invoke(city: City): Weather =
        weatherRepository.get(city.lat, city.lon)
}