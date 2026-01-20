package com.example.nadanao.front

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.example.nadanao.viewmodel.MapViewModel

@Composable
fun MapPage(viewModel: MapViewModel) {

    val pontoSelecionado = viewModel.pontoSelecionado.value

    Box {
        // Aqui entra o mapa (Google Maps Compose depois)

        pontoSelecionado?.let { ponto ->
            PontoDialog(
                ponto = ponto,
                onDismiss = { viewModel.limparSelecao() }
            )
        }
    }
}
