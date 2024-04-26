package com.example.weather.data.dataSource

import com.example.weather.domain.model.City
import javax.inject.Inject

class DefaultCityDataSource @Inject constructor() {

    fun get(): List<City> = listOf(
        City(lat = "56.20417786", lon = "95.70665741", fullName = "Канск"),
        City(lat = "43.11554337", lon = "131.885498", fullName = "Владивосток"),
        City(lat = "69.40576935", lon = "86.16499329", fullName = "Дудинка"),
        City(lat = "55.4507", lon = "37.3656", fullName = "Москва"),
        City(lat = "59.57", lon = "30.19", fullName = "Санкт-Петербург"),
    )
}