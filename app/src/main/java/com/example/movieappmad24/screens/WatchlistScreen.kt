package com.example.movieappmad24.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.movieappmad24.models.getMovies // Assume this returns hardcoded list of movies
import com.example.movieappmad24.navigation.Screen

@Composable
fun WatchlistScreen(navController: NavHostController) {
    MovieList(movies = getMovies()) { movieId ->
        // This could navigate to a detailed view of the movie in the watchlist
        navController.navigate(Screen.Detail.createRoute(movieId))
    }
}