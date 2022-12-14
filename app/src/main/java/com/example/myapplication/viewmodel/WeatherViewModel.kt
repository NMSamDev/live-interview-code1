package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Repository
import com.example.myapplication.model.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private val _weather = MutableLiveData<UIState>()
    val weather: LiveData<UIState>
    get() = _weather

    fun getWeather(location: String){
        viewModelScope.launch {
            repository.getWeather(location).collect {
                _weather.value = it
            }
        }

//        val job1 = viewModelScope.async {
//            repository.getWeather(location)
//        }.await()
    }

}