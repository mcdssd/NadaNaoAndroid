package com.example.nadanao.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.nadanao.model.PontoMapa

class MapViewModel : ViewModel() {

    private val _pontoSelecionado = mutableStateOf<PontoMapa?>(null)
    val pontoSelecionado = _pontoSelecionado

    fun selecionar(ponto: PontoMapa) {
        _pontoSelecionado.value = ponto
    }

    fun limparSelecao() {
        _pontoSelecionado.value = null
    }
}
