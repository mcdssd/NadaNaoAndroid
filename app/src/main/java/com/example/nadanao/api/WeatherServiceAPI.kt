package com.example.nadanao.api

import com.example.nadanao.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherServiceAPI {

    companion object {
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val API_KEY = BuildConfig.WEATHER_API_KEY
    }

    @GET("current.json?key=$API_KEY&lang=pt_br")
    fun getWeather(
        @Query("q") location: String
    ): Call<APIWeather>
}