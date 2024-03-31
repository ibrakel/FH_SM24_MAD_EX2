package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.movieappmad24.components.BottomNavigation
import com.example.movieappmad24.components.MovieRow
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavHostController, movieId: String) {
    val movie = getMovies().firstOrNull { it.id == movieId }

    MovieAppMAD24Theme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text(movie?.title ?: "Movie Details") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Filled.ArrowBack, "Back")
                        }
                    }
                )
            },
            bottomBar = {
                BottomNavigation(navController = navController)
            }

        ) { innerPadding ->
            movie?.let {
                Column(modifier = Modifier.padding(innerPadding)) {
                    MovieRow(movie = it, onMovieClick = {}) // Reuse your MovieRow component here
                    MovieImagesGallery(it)// Additional LazyRow for image gallery as needed
                }
            }
        }
    }
}

@Composable
fun MovieImagesGallery(movie: Movie) {
    LazyRow {
        items(movie.images) { imageUrl ->
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier.size(300.dp, 250.dp),
                loading = { CircularProgressIndicator() }
            )
        }
    }
}

