package com.example.myapplication.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.DisplayWeatherBinding
import com.example.myapplication.model.UIState
import com.example.myapplication.model.remote.WeatherResponse
import com.example.myapplication.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "WeatherFragment"

@AndroidEntryPoint
class WeatherFragment: Fragment() {

    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var binding: DisplayWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DisplayWeatherBinding.inflate(inflater, container, false)

        initObservables()
        viewModel.getWeather("visakhapatnam")
        return binding.root
    }

    private fun initObservables() {
        viewModel.weather.observe(viewLifecycleOwner){
            when(it){
                is UIState.Success -> { updateView(it.data) }
                is UIState.Failure -> { showError(it.errorMessage) }
                is UIState.Loading -> { showLoading(it.loading)}
            }
        }
    }

    private fun showLoading(loading: Boolean) {
        requireActivity().isLoading(loading)
    }

    private fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    private fun updateView(data: WeatherResponse) {
        Log.d(TAG, "updateView: $data")
        binding.apply {
            weatherName.text = data.location.name
            weatherCountry.text = data.location.country
            weatherRegion.text = data.location.region
        }
    }

    private fun FragmentActivity.isLoading(loading: Boolean) {
        if (loading){
            findViewById<ProgressBar>(R.id.loading).visibility = View.VISIBLE
        }else{
            findViewById<ProgressBar>(R.id.loading).visibility = View.GONE
        }
    }
}