package com.example.movieappmad24.screens

import MoviesViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieappmad24.components.BottomNavigation
import com.example.movieappmad24.components.MovieRow
import com.example.movieappmad24.models.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, movieId: String, viewModel: MoviesViewModel) {
    val movieState = viewModel.getMovieById(movieId).collectAsState().value  // Collect the movie state as State

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(movieState?.title ?: "Movie Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation(navController)
        }
    ) { innerPadding ->
        movieState?.let { movie ->
            Column(modifier = Modifier.padding(innerPadding)) {
                // No click action is necessary for the movie itself in the detail view
                MovieRow(movie = movie, onMovieClick = { }, onFavoriteClick = { viewModel.toggleFavorite(movie.id) })
                MovieImagesGallery(movie)
            }
        } ?: run {
            // Handle the case where the movie is null
            Text("Movie details not available", modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun MovieImagesGallery(movie: Movie) {
    LazyRow(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        items(movie.images) { imageUrl ->
            AsyncImage(
                model = imageUrl,
                contentDescription = "Movie Image",
                modifier = Modifier.size(300.dp, 250.dp)
            )
        }
    }
}
