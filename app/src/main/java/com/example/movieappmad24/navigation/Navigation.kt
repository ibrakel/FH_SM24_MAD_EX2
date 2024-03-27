package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController() // create a NavController instance
    NavHost(
        navController = navController, // pass the NavController to NavHost
        startDestination = "homescreen", // pass a start destination
        modifier = modifier // applying the passed modifier
    ) {
        composable(route = "homescreen") { // use named argument for consistency
            HomeScreen(navController) // Assuming HomeScreen takes NavController as a parameter
        }
        composable(route = "detailscreen") { // use named argument for consistency
            DetailScreen(navController) // Assuming DetailScreen takes NavController as a parameter
        }
    }
}