package com.example.weather.presentation.ui.mainScreen

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.domain.model.City
import com.example.weather.domain.useCase.GetCityUseCase
import com.example.weather.domain.useCase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getCityUseCase: GetCityUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MainScreenState>(
        MainScreenState.ChoiceCityState(
            cities = getCityUseCase(),
        )
    )
    val uiState: StateFlow<MainScreenState> = _uiState.asStateFlow()

    @SuppressLint("SuspiciousIndentation")
    fun onCityChange(city: City) {
        val state = _uiState.value
        _uiState.value = MainScreenState.LoadingState

        if (state is MainScreenState.ChoiceCityState) {

            viewModelScope.launch {
                runCatching {
                    getWeatherUseCase(city = city).temp
                }
                    .onFailure { error ->
                        _uiState.value = MainScreenState.ErrorState(error)
                    }
                    .onSuccess { result ->
                        _uiState.value = MainScreenState.DataState(
                            selectedCity = city,
                            temperature = result
                        )
                    }
            }
        }
    }

    fun setChoiceCityState() {
        _uiState.value = MainScreenState.ChoiceCityState(
            cities = getCityUseCase()
        )
    }
}