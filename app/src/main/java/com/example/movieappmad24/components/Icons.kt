package com.example.movieappmad24.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

@Composable
fun FavoriteIcon() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.TopEnd
    ){
        Icon(
            tint = MaterialTheme.colorScheme.secondary,
            imageVector = Icons.Default.FavoriteBorder,
            contentDescription = "Add to favorites")
    }
}