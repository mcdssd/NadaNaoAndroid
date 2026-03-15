package com.example.nadanao.front

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nadanao.model.ChecklistItem

@Composable
fun Checklist() {



    val items = remember {
        mutableStateListOf(
            ChecklistItem("Protetor solar"),
            ChecklistItem("Água"),
            ChecklistItem("Chapéu ou boné"),
            ChecklistItem("Toalha"),
            ChecklistItem("Óculos de sol")
        )
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        // textos no topo
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Checklist da Praia",
            )

            Text(
                text = "Veja se você já pegou tudo antes de sair!",

            )
        }

        Spacer(Modifier.height(24.dp))

        LazyColumn {

            items(items) { item ->

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            item.checked = !item.checked
                        }
                        .padding(vertical = 8.dp)
                ) {

                    Checkbox(
                        checked = item.checked,
                        onCheckedChange = {
                            item.checked = it
                        }
                    )

                    Text(
                        text = item.text
                    )
                }
            }
        }
    }
}