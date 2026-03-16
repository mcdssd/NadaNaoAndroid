package com.example.nadanao.api

import android.util.Log
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class WeatherService {

    private var weatherAPI: WeatherServiceAPI

    init {
        val retrofitAPI = Retrofit.Builder()
            .baseUrl(WeatherServiceAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        weatherAPI = retrofitAPI.create(WeatherServiceAPI::class.java)
    }

    fun getTemperature(
        lat: Double,
        lon: Double,
        onResponse: (Double?) -> Unit
    ) {

        val call = weatherAPI.getWeather("$lat,$lon")

        call.enqueue(object : Callback<APIWeather> {

            override fun onResponse(
                call: Call<APIWeather>,
                response: Response<APIWeather>
            ) {

                val temp = response.body()?.current?.temp_c
                onResponse(temp)

            }

            override fun onFailure(call: Call<APIWeather>, t: Throwable) {

                Log.w("WeatherAPI", t.message ?: "erro")
                onResponse(null)

            }
        })
    }
}