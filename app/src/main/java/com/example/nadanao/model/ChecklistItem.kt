package com.example.nadanao.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ChecklistItem(
    val text: String,
    checked: Boolean = false
) {
    var checked by mutableStateOf(checked)
}

