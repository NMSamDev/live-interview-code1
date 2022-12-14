package com.example.myapplication.model

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getWeather(location:String): Flow<UIState>
}