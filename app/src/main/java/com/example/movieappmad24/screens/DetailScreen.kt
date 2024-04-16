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
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.movieappmad24.components.BottomNavigation
import com.example.movieappmad24.components.MovieRow
import com.example.movieappmad24.models.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, movieId: String, viewModel: MoviesViewModel) {
    val movie = viewModel.getMovieById(movieId)  // Assuming ViewModel provides a method to get movie by ID

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(movie?.title ?: "Movie Details") },
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
        movie?.let { movie ->
            Column(modifier = Modifier.padding(innerPadding)) {
                MovieRow(movie = movie, onMovieClick = { }, onFavoriteClick = viewModel::toggleFavorite)
                MovieImagesGallery(movie)
            }
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
