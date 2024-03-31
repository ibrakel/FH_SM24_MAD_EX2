package com.example.movieappmad24.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.example.movieappmad24.ui.theme.Pink40

@Composable
fun ExpandToggleButton(showDetails: Boolean, onToggle: (Boolean) -> Unit) {
    IconButton(onClick = { onToggle(!showDetails) }) {
        Icon(
            imageVector = if (showDetails) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = if (showDetails) "Hide details" else "Show details",
            tint = Pink40
        )
    }
}