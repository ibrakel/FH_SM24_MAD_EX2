package com.example.movieappmad24.screens

import MoviesViewModel
import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.movieappmad24.components.BottomNavigation
import com.example.movieappmad24.components.MovieTopBar
import com.example.movieappmad24.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WatchlistScreen(viewModel: MoviesViewModel, navController: NavController) {
    Scaffold(
        topBar = { MovieTopBar("Watchlist") },
        bottomBar = { BottomNavigation(navController) }  // Assuming navController is passed as a parameter
    ) { innerPadding ->
        // Display only favorite movies
        MovieList(
            movies = viewModel.favorites.collectAsState().value,
            onMovieClick = { movieId ->
                navController.navigate(Screen.Detail.createRoute(movieId))
            },
            onFavoriteClick = viewModel::toggleFavorite
        )
    }
}
