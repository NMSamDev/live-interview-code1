package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.view.WeatherFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, WeatherFragment())
            .commit()
    }
}

/*
Web Service
URL https://api.weatherapi.com/v1/current.jsonRequest method GET


Parameters
key=”520916eb3f46442ca1c12926221402”  , q=”any city name”

Example
https://api.weatherapi.com/v1/current.json?key=520916eb3f46442ca1c12926221402&q=visakhapatnam

Response JSON
{
 "location": {
   "name": "Visakhapatnam",
   "region": "Andhra Pradesh",
   "country": "India",
   "localtime": "2022-03-25 19:46"
 },
 "current": {
   "last_updated": "2022-03-25 18:30",
   "temp_c": 29.1,
   "temp_f": 84.4,
   "is_day": 0,
   "condition": {
     "text": "Clear",
     "icon": "//cdn.weatherapi.com/weather/64x64/night/113.png",
     "code": 1000
   },
   "wind_mph": 13.6,
   "wind_kph": 22.0,
   "humidity": 79,
   "cloud": 6,
   } }



Bonus Points
● Error handling
● Unit test
● Network connection check

 */