package com.example.movieappmad24.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.ui.theme.Purple40

@Composable
fun TitleSection(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineMedium.copy(color = Purple40),
        modifier = Modifier
            .padding(8.dp)
    )
}