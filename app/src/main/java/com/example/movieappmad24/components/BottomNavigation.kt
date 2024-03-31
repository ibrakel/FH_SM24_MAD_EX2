package com.example.movieappmad24.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigation(navController: NavController) {
    NavigationBar {
        val currentRoute = navController.currentDestination?.route
        NavigationBarItem(
            label = { Text("Home") },
            selected = currentRoute == "home",
            onClick = { navController.navigate("home") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            } },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Go to home") }
        )
        NavigationBarItem(
            label = { Text("Watchlist") },
            selected = currentRoute == "watchlist",
            onClick = { navController.navigate("watchlist") {
                popUpTo(navController.graph.startDestinationId)
                launchSingleTop = true
            } },
            icon = { Icon(Icons.Filled.Star, contentDescription = "Go to watchlist") }
        )
    }
}