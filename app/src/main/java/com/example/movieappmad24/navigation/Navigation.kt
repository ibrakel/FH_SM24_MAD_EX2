package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument



sealed class Screen(val route: String) {
    object Home : Screen("homescreen")
    object Detail : Screen("detailscreen/{movieId}") {
        fun createRoute(movieId: String) = "detailscreen/$movieId"
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController) // Pass NavController here
        }
        composable(
            route = Screen.Detail.route, // "detailscreen/{movieId}"
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailScreen(
                navController,
                movieId = backStackEntry.arguments?.getString("movieId") ?: "",
                )
        }
    }
}