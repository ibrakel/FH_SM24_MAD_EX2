package com.example.movieappmad24.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopBar(title: String = "Movie App", showBackButton: Boolean = false, onNavigateUp: () -> Unit = {}) {
    MovieAppMAD24Theme {
        CenterAlignedTopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                if (showBackButton) (run {
                    IconButton(onClick = onNavigateUp) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }) else null
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
    }
}
