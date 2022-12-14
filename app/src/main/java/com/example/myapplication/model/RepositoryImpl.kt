package com.example.myapplication.model

import com.example.myapplication.model.remote.WeatherService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RepositoryImpl(private val service: WeatherService): Repository {
    override fun getWeather(location: String): Flow<UIState> {
        return flow {
            emit(UIState.Loading(true))

            val response = service.getCurrentWeather(location= location)

            if (response.isSuccessful){
                response.body()?.let {
                    emit(UIState.Success(it))
                } ?: emit(UIState.Failure(response.message()))
            }else
                emit(UIState.Failure(response.message()))

            emit(UIState.Loading(false))
        }
    }
}