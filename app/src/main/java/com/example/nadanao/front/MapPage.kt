package com.example.nadanao.front

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.nadanao.viewmodel.MapViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapPage(viewModel: MapViewModel, userLocation: LatLng?,
            onLocationSelected: (LatLng) -> Unit) {


    val defaultLocation = userLocation ?: LatLng(-8.05, -34.9)
//    val recife = LatLng(-8.05, -34.9)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(defaultLocation, 12f)
    }

//    val cameraPositionState = rememberCameraPositionState {
//        position = CameraPosition.fromLatLngZoom(recife, 12f)
//    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        onMapClick = { latLng ->

            viewModel.setLocalSelecionada(latLng)

            viewModel.updateTemperature(
                latLng.latitude,
                latLng.longitude
            )
            onLocationSelected(latLng)
        }
    ) {

        viewModel.localSelecionada.value?.let { location ->

            Marker(
                state = MarkerState(position = location),
                title = "Local selecionado"
            )

        }

    }

    // Dialog
    viewModel.pontoSelecionado.value?.let { ponto ->
        PontoDialog(
            ponto = ponto,
            onDismiss = { viewModel.limparSelecao() }
        )
    }
}

private fun Double.format(decimals: Int): String =
    "%.${decimals}f".format(this)
