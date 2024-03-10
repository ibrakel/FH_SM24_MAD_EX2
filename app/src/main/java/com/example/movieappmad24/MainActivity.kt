package com.example.movieappmad24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import coil.compose.rememberImagePainter
import com.example.movieappmad24.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MovieList(movies: List<Movie> = getMovies(), modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(movies) { movie ->
            MovieRow(movie = movie)
        }
    }
}

@Composable
fun MainScreen() {
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
        MovieList(movies = getMovies(), modifier = Modifier.padding(innerPadding))
    }
}
@Composable
fun BottomBar(items: List<BottomNavItem>, currentRoute: String, onItemSelected: (String) -> Unit) {
    NavigationBar { // Assuming Material 3, using NavigationBar for Material 3 BottomNavigation
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item.route) }
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTopBar() {
    CenterAlignedTopAppBar(
        title = { Text("MovieAppMAD24") }
    )
}

data class BottomNavItem(val name: String, val icon: ImageVector, val route: String)



@Composable
fun MovieRow(movie: Movie) {
    var showDetails by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column {
            // Movie image and title always visible
            movie.images.firstOrNull()?.let { imageUrl ->
                Image(
                    painter = rememberImagePainter(imageUrl),
                    contentDescription = "${movie.title} image",
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = movie.title,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(8.dp)
            )

            // Toggle Icon Button for showing/hiding details
            IconButton(onClick = { showDetails = !showDetails }) {
                Icon(
                    imageVector = if (showDetails) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = if (showDetails) "Hide details" else "Show details"
                )
            }

            // Details visible only when expanded
            AnimatedVisibility(visible = showDetails) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Director: ${movie.director}", style = MaterialTheme.typography.bodyMedium)
                    Text("Year: ${movie.year}", style = MaterialTheme.typography.bodyMedium)
                    Text("Genre: ${movie.genre}", style = MaterialTheme.typography.bodyMedium)
                    Text("Rating: ${movie.rating}", style = MaterialTheme.typography.bodyMedium)
                    Text("Plot: ${movie.plot}", style = MaterialTheme.typography.bodyMedium)
                    Text("Actors: ${movie.actors}", style = MaterialTheme.typography.bodyMedium)
                    // Add more details as needed
                }
            }
        }
    }
}




@Preview
@Composable
fun DefaultPreview(){
    MovieAppMAD24Theme {
       MovieList(movies = getMovies())
    }
}
