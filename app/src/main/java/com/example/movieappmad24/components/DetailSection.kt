package com.example.movieappmad24.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.models.Movie

@Composable
fun DetailSection(movie: Movie) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text("Director: ${movie.director}", style = MaterialTheme.typography.bodyMedium)
        Text("Year: ${movie.year}", style = MaterialTheme.typography.bodyMedium)
        Text("Genre: ${movie.genre}", style = MaterialTheme.typography.bodyMedium)
        Text("Rating: ${movie.rating}", style = MaterialTheme.typography.bodyMedium)
        Text("Plot: ${movie.plot}", style = MaterialTheme.typography.bodyMedium)
        Text("Actors: ${movie.actors}", style = MaterialTheme.typography.bodyMedium)
    }
}