package com.example.myapplication.model.remote


import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val current: Current,
    val location: Location
)