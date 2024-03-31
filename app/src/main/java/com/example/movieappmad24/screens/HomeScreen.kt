package com.example.movieappmad24.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.movieappmad24.components.BottomBar
import com.example.movieappmad24.components.ImageSection
import com.example.movieappmad24.components.MovieRow
import com.example.movieappmad24.components.MovieTopBar
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme
import com.example.movieappmad24.ui.theme.Pink40
import com.example.movieappmad24.ui.theme.Purple40
import com.example.movieappmad24.ui.theme.PurpleGrey80




@Composable
fun MovieList(movies: List<Movie> = getMovies(), modifier: Modifier = Modifier, onItemClick: (String) -> Unit) {
    LazyColumn(modifier = modifier) {
        items(movies) { movie ->
            MovieRow(movie = movie, onItemClick = onItemClick)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    val bottomNavItems = listOf(
        BottomNavItem("Home", Icons.Filled.Home, "home"),
        BottomNavItem("Watchlist", Icons.Filled.Star, "watchlist")
    )
    var currentRoute by remember { mutableStateOf("home") }

    Scaffold(
        topBar = { MovieTopBar() },
        bottomBar = {
            BottomBar(bottomNavItems, currentRoute) { route ->
                currentRoute = route
            }
        }
    ) { innerPadding ->
        MovieList(movies = getMovies(), modifier = Modifier.padding(innerPadding)){ movieId ->
            navController.navigate(Screen.Detail.createRoute(movieId))
        }
    }
}



data class BottomNavItem(val name: String, val icon: ImageVector, val route: String)



@Preview
@Composable
fun DefaultPreview(){
    MovieAppMAD24Theme {
        MovieList(movies = getMovies(), onItemClick = { /* No-op for preview */ })
    }
}
