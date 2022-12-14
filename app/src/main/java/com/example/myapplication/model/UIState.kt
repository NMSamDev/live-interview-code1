package com.example.myapplication.model

import com.example.myapplication.model.remote.WeatherResponse

sealed class UIState{
    data class Success(val data: WeatherResponse) : UIState()
    data class Failure(val errorMessage: String): UIState()
    data class Loading(val loading: Boolean): UIState()
}
