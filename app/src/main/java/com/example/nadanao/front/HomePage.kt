import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.example.nadanao.R
import com.example.nadanao.front.MapPage
import com.example.nadanao.front.components.ButtonCard
import com.example.nadanao.front.components.SharkBanner
import com.example.nadanao.viewmodel.MapViewModel

@Composable
fun HomePage(navController: NavController, viewModel: MapViewModel) {
    var showPopup by remember { mutableStateOf(false) }
    val local = viewModel.localSelecionada.value


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {


        Row (modifier = Modifier.fillMaxWidth()) {

            Spacer(Modifier.height(height = 50.dp))

            Text(
                text = if (local == null) {
                    "Recife, Pernambuco"
                } else {
                    "${local.latitude.format(4)}, ${local.longitude.format(4)}"
                },
                modifier = Modifier
                    .clickable {
                        showPopup = true
                    }
                    .padding(8.dp),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )

            Text(
                text = "27º C",
                modifier = Modifier
                    .clickable {
                        showPopup = true
                    }
                    .padding(8.dp),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )


        }

        Row (modifier = Modifier.fillMaxWidth()) {

            Spacer(Modifier.width(width = 5.dp))

            Image(
                painter = painterResource(id = R.drawable.titulohome),
                contentDescription = "Nada Não",
                modifier = Modifier
                    .height(120.dp)
                    .width(width = 150.dp)

            )}

        SharkBanner()

        Spacer(Modifier.height(32.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            ButtonCard(
                title = "Água Boa pra Nadar?",
                icon = R.drawable.aguaboa, // troque pelo seu ícone
                backgroundColor = Color(0xFFF8A8B8),
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate("Aguaboa")
                }
            )
            Spacer(Modifier.width(16.dp))
            ButtonCard(
                title = "Praia Tá Limpa?",
                icon = R.drawable.praialimpa,
                backgroundColor = Color(0xFF8FF1FF),
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate("PraiaLimpa")
                }
            )
        }

        Spacer(Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            ButtonCard(
                title = "Por Dentro da Praia",
                icon = R.drawable.pordentropraia,
                backgroundColor = Color(0xFFFFEB77),
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate("PorDentroPraia")
                }
            )
            Spacer(Modifier.width(16.dp))
            ButtonCard(
                title = "Checklist da Praia de Hoje",
                icon = R.drawable.checklist,
                backgroundColor = Color(0xFFE3C3FF),
                modifier = Modifier.weight(1f),
                onClick = {
                    navController.navigate("Checklist")
                }
            )
        }
    }

    if (showPopup) {
        Dialog(onDismissRequest = { showPopup = false }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(Color.White, RoundedCornerShape(20.dp))
            ) {
                MapPage(viewModel)
            }
        }
    }


}
private fun Double.format(decimals: Int): String =
    "%.${decimals}f".format(this)

