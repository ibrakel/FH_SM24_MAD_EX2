package com.example.movieappmad24.navigation


sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Watchlist : Screen("watchlist_screen")
    object Detail : Screen("detail_screen/{movieId}") {
        fun createRoute(movieId: String): String = "detail_screen/$movieId"
    }
}
