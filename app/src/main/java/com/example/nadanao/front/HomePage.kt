import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nadanao.R
import com.example.nadanao.front.components.ButtonCard
import com.example.nadanao.front.components.SharkBanner

@Composable
fun HomePage() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {





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
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(16.dp))
            ButtonCard(
                title = "Praia Tá Limpa?",
                icon = R.drawable.praialimpa,
                backgroundColor = Color(0xFF8FF1FF),
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            ButtonCard(
                title = "Por Dentro da Praia",
                icon = R.drawable.pordentropraia,
                backgroundColor = Color(0xFFFFEB77),
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(16.dp))
            ButtonCard(
                title = "Checklist da Praia de Hoje",
                icon = R.drawable.checklist,
                backgroundColor = Color(0xFFE3C3FF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}
