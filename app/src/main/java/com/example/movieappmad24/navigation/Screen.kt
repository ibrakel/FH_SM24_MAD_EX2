package com.example.movieappmad24.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Detail : Screen("detail_screen/{movieId}/{detailVisibility}") {
        fun createRoute(movieId: String, detailVisibility: Boolean) = "detail_screen/$movieId/$detailVisibility"
    }
    object Watchlist : Screen("watchlist_screen")

}