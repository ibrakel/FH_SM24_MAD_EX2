package com.example.movieappmad24.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.movieappmad24.screens.BottomNavItem

@Composable
fun BottomBar(items: List<BottomNavItem>, currentRoute: String, onItemSelected: (String) -> Unit) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item.route) }
            )
        }
    }
}