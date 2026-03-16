package com.example.nadanao.api


data class APIWeather(
    var current: APICurrent? = null
)

data class APICurrent(
    var temp_c: Double? = null
)