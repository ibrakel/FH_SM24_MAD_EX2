package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController, movieId: String) {
    Scaffold(
        topBar = { /* TopAppBar setup, including back navigation */ }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Movie ID: $movieId")
            // Display more movie details as needed
        }
    }
}