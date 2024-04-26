package com.example.weather.domain.useCase

import com.example.weather.data.repository.CityRepository
import com.example.weather.domain.model.City
import javax.inject.Inject

class GetCityUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {

    operator fun invoke(): List<City> = cityRepository.get()
}