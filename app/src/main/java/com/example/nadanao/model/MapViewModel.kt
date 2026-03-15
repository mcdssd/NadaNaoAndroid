package com.example.nadanao.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
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
}
