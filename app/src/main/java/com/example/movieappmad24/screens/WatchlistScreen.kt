package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.movieappmad24.components.BottomNavigation
import com.example.movieappmad24.components.MovieTopBar
import com.example.movieappmad24.models.getMovies // Assume this returns hardcoded list of movies
import com.example.movieappmad24.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WatchlistScreen(navController: NavController) {
    // Assuming you have a similar function to getMovies() for watchlist
    val watchlistMovies = getMovies() // Modify this to your actual watchlist fetching logic

    Scaffold(
        topBar = { MovieTopBar(title = "Watchlist") }, // Updated to pass title dynamically
        bottomBar = { BottomNavigation(navController = navController) } // Use the new BottomNavigation component
    ) { innerPadding ->
        MovieList(
            movies = watchlistMovies,
            modifier = Modifier.padding(innerPadding),
            onMovieClick = { movieId ->
                // Navigate to the detail screen with the selected movie ID
                navController.navigate(Screen.Detail.createRoute(movieId))
            }
        )
    }
}