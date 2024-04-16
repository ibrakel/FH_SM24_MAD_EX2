package com.example.movieappmad24.navigation

import MoviesViewModel
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.WatchlistScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val moviesViewModel: MoviesViewModel = viewModel()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController, moviesViewModel)
        }
        composable(route = Screen.Watchlist.route) {
            WatchlistScreen( moviesViewModel, navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailScreen(navController,
                movieId = backStackEntry.arguments?.getString("movieId") ?: "",
                viewModel=moviesViewModel)
        }
    }
}