package com.example.weather.presentation.ui.mainScreen.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.presentation.ui.mainScreen.MainScreenState
import com.example.weather.presentation.ui.mainScreen.MainViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val state by viewModel.uiState.collectAsState()

    when (val immutableState = state) {
        is MainScreenState.LoadingState -> {
            CircularProgressIndicator(
                modifier = Modifier.padding(100.dp, 200.dp),
                color = Color.Red
            )
        }

        is MainScreenState.DataState -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "${immutableState.selectedCity.fullName} = ${immutableState.temperature}",
                    fontSize = 30.sp,
                )
                Button(onClick = { viewModel.setChoiceCityState() }) {
                    Text(text = stringResource(R.string.buttonname))
                }
            }
        }

        is MainScreenState.ErrorState -> {
            Text(
                text = immutableState.error.toString(),
                fontSize = 30.sp,
            )
        }

        is MainScreenState.ChoiceCityState -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {

                Text(
                    text = stringResource(R.string.choice),
                    fontSize = 30.sp,
                )

                LazyColumn {
                    items(immutableState.cities.size) { index ->
                        val city = immutableState.cities[index]

                        Text(
                            text = city.fullName,
                            fontSize = 30.sp,
                            modifier = Modifier
                                .clickable { viewModel.onCityChange(city) }
                        )
                    }
                }
            }
        }
    }
}