package com.example.movieappmad24.navigation


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Watchlist : Screen("watchlist")
    object Detail : Screen("detail_screen/{movieId}") {
        fun createRoute(movieId: String): String = "detail_screen/$movieId"
    }
}
