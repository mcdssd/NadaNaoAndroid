package com.example.nadanao.front

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.nadanao.viewmodel.MapViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapPage(viewModel: MapViewModel) {

    val recife = LatLng(-8.05, -34.9)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(recife, 12f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapClick = { latLng ->
            viewModel.setLocalSelecionada(latLng)

            viewModel.add(
                nome = "Ponto ${latLng.latitude.format(4)}, ${latLng.longitude.format(4)}",
                location = latLng
            )
        }
    ) {
        // marcadores que vêm do ViewModel
        viewModel.pontos.forEach { ponto ->
            val pos = LatLng(ponto.latitude, ponto.longitude)

            Marker(
                state = MarkerState(position = pos),
                title = ponto.nome,
                snippet = ponto.descricao,
                onClick = {
                    viewModel.setLocalSelecionada(pos)
                    viewModel.selecionar(ponto)
                    true
                }
            )
        }
    }

    // seu Dialog aparece quando seleciona
    viewModel.pontoSelecionado.value?.let { ponto ->
        PontoDialog(
            ponto = ponto,
            onDismiss = { viewModel.limparSelecao() }
        )
    }
}

private fun Double.format(decimals: Int): String =
    "%.${decimals}f".format(this)
