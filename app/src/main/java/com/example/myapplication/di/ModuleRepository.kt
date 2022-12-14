package com.example.myapplication.di

import com.example.myapplication.model.Repository
import com.example.myapplication.model.RepositoryImpl
import com.example.myapplication.model.remote.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ModuleRepository {

    @Provides
    fun provideRepository(service: WeatherService):Repository =
        RepositoryImpl(service)
}