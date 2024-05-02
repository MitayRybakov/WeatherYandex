package com.example.weather.data.repository

import com.example.weather.data.dataSource.DefaultCityDataSource
import com.example.weather.domain.model.City
import javax.inject.Inject

class CityRepository @Inject constructor(
    private val defaultCityDataSource: DefaultCityDataSource,
) {

    fun get(): List<City> = defaultCityDataSource.get()
}