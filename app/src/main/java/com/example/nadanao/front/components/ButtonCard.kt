package com.example.nadanao.front.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonCard(
    title: String,
    icon: Int,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(backgroundColor, RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {

            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(36.dp)
            )

            Text(
                text = title,
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}
