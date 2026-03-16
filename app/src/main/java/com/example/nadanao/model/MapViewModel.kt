package com.example.nadanao.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.nadanao.api.WeatherService
import com.example.nadanao.model.PontoMapa
import com.google.android.gms.maps.model.LatLng
import java.util.UUID


class MapViewModel : ViewModel() {

    private val _pontos = mutableStateListOf<PontoMapa>()
    val pontos: List<PontoMapa> get() = _pontos

    private val _pontoSelecionado = mutableStateOf<PontoMapa?>(null)
    val pontoSelecionado = _pontoSelecionado

    private val _localSelecionada = mutableStateOf<LatLng?>(null)
    val localSelecionada = _localSelecionada

    private val weatherService = WeatherService()

    var temperature by mutableStateOf<Double?>(null)
        private set

    fun setLocalSelecionada(latLng: LatLng) {
        _localSelecionada.value = latLng
    }

    fun add(nome: String, location: LatLng) {
        _pontos.add(
            PontoMapa(
                id = UUID.randomUUID().toString(),
                nome = nome,
                descricao = "Adicionado pelo mapa",
                latitude = location.latitude,
                longitude = location.longitude
            )
        )
    }


    fun selecionar(ponto: PontoMapa) {
        _pontoSelecionado.value = ponto
    }

    fun limparSelecao() {
        _pontoSelecionado.value = null
    }

    fun updateTemperature(lat: Double, lon: Double) {

        weatherService.getTemperature(lat, lon) { temp ->

            temperature = temp

        }
    }
}
