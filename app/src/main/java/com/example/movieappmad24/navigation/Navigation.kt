package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import androidx.compose.ui.Modifier

@Composable
fun Navigation(modifier: Modifier) {
    val navController = rememberNavController() // create a NavController instance
    NavHost(navController = navController, // pass the NavController to NavHost
        startDestination = "homescreen") { // pass a start destination
        composable(route = "homescreen"){
            HomeScreen()
        }
        composable("detailscreen") {
            DetailScreen()
        }
    }
}