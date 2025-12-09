package com.example.nadanao.front.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import com.example.nadanao.R

@Composable
fun SharkBanner() {
    Surface(
        color = Color(0xFFCDEEFF), // azul clarinho do fundo
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            // 🦈 Imagem do tubarão
            Image(
                painter = painterResource(id = R.drawable.joca_oculos),
                contentDescription = "Tubarão",
                modifier = Modifier
                    .height(120.dp)
                    .width(width = 150.dp)
            )

            Spacer(Modifier.width(12.dp))

            // Texto
            Text(
                text = "Mar tranquilo,\nhora de nadar!",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A)
            )
        }
    }
}