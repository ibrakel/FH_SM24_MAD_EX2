package com.example.movieappmad24.screens


import MoviesViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.movieappmad24.components.BottomNavigation
import com.example.movieappmad24.components.MovieRow
import com.example.movieappmad24.components.MovieTopBar
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme
import kotlinx.coroutines.flow.StateFlow


@Composable
fun MovieList(modifier: Modifier = Modifier, movies: List<Movie>, onMovieClick: (String) -> Unit, onFavoriteClick: (String) -> Unit) {
    LazyColumn(modifier = modifier) {
        items(movies) { movie ->
            MovieRow(movie = movie, onMovieClick = onMovieClick, onFavoriteClick = onFavoriteClick)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController, viewModel: MoviesViewModel) {
    val movies by viewModel.movies.collectAsState()  // Collect movies as state

    Scaffold(
        topBar = { MovieTopBar() },
        bottomBar = { BottomNavigation(navController = navController) }
    ) { innerPadding ->
        MovieList(
            movies = movies,  // Pass the collected state
            modifier = Modifier.padding(innerPadding),
            onMovieClick = { movieId -> navController.navigate(Screen.Detail.createRoute(movieId)) },
            onFavoriteClick = viewModel::toggleFavorite
        )
    }
}




data class BottomNavItem(val name: String, val icon: ImageVector, val route: String)



@Preview
@Composable
fun DefaultPreview(){
    MovieAppMAD24Theme {
        MovieList(movies = getMovies(), onMovieClick = { /* No-op for preview */ }) {}
    }
}
