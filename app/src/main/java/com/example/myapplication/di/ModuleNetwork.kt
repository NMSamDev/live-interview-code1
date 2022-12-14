package com.example.myapplication.di

import com.example.myapplication.model.remote.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ModuleNetwork {
    @Provides
    fun provideService(retrofit: Retrofit): WeatherService {
        return retrofit
            .create(WeatherService::class.java)
    }

    @Provides
    fun provideRetrofit(converter: Converter.Factory) =
        Retrofit.Builder()
                //https://api.weatherapi.com/v1/current.json?key=520916eb3f46442ca1c12926221402&q=visakhapatnam
            .baseUrl("https://api.weatherapi.com/")
            .addConverterFactory(converter)
            .build()

    @Provides
    fun provideConverter(): Converter.Factory = GsonConverterFactory.create()

}