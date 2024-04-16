import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies.asStateFlow()
    private val _favorites = MutableStateFlow<List<Movie>>(emptyList())
    val favorites: StateFlow<List<Movie>> = _favorites.asStateFlow()

    init {
        loadMovies()
        observeFavorites()
    }

    private fun loadMovies() {
        // Simulate loading data (replace with your actual data loading logic)
        _movies.value = getMovies() // Assuming getMovies() fetches your initial data
    }

    fun toggleFavorite(movieId: String) {
        _movies.value = _movies.value.map { movie ->
            if (movie.id == movieId) movie.copy(isFavorite = !movie.isFavorite)
            else movie
        }
    }

    private fun observeFavorites() {
        viewModelScope.launch {
            _movies.map { movies ->
                movies.filter { it.isFavorite }
            }.collect {
                _favorites.value = it
            }
        }
    }
    fun getMovieById(movieId: String): StateFlow<Movie?> {
        // Return a StateFlow that always emits the current movie for the given ID or null if it doesn't exist
        return _movies.map { movies ->
            movies.find { it.id == movieId }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), null)
    }
}
