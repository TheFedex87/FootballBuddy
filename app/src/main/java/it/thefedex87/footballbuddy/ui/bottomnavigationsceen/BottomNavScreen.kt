package it.thefedex87.footballbuddy.ui.bottomnavigationsceen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreen(
    val route: String,
    val icon: ImageVector,
    val title: String
) {
    object Teams : BottomNavScreen(route = "teams", icon = Icons.Default.Home, title = "Teams")
    object LiveScore : BottomNavScreen(route = "liveScore", icon = Icons.Default.Favorite, title = "Teams")
}