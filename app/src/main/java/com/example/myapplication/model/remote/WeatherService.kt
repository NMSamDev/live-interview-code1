package com.example.myapplication.model.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    //https://api.weatherapi.com/v1/current.json?key=520916eb3f46442ca1c12926221402&q=visakhapatnam
    @GET("/v1/current.json")
    suspend fun getCurrentWeather(
        @Query("key") keyApi: String = "520916eb3f46442ca1c12926221402",
        @Query("q") location: String
    ): Response<WeatherResponse>
}