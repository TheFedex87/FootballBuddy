package it.thefedex87.footballbuddy.ui.bottomnavigationsceen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavScreen.Teams.route,
            modifier = modifier
        ) {
            composable(BottomNavScreen.Teams.route) {
                Text(text = "TEAMS")
            }
            composable(BottomNavScreen.LiveScore.route) {
                Text(text = "LIVE SCORE")
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavScreen.Teams,
        BottomNavScreen.LiveScore
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Teams screen")
        },
        label = {
            Text(text = screen.title)
        },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}