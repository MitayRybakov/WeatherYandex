package com.example.weather.presentation.ui.mainScreen

import com.example.weather.domain.model.City

sealed class MainScreenState {

    data class DataState(
        val selectedCity: City,
        val temperature: Int,
    ) : MainScreenState()

    data class ErrorState(
        val error: Throwable,
    ) : MainScreenState()

    data object LoadingState : MainScreenState()

    data class ChoiceCityState(
        val cities: List<City>
    ) : MainScreenState()
}