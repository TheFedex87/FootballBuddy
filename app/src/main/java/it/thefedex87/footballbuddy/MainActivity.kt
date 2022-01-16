package it.thefedex87.footballbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import it.thefedex87.footballbuddy.ui.bottomnavigationsceen.BottomNavigationScreen
import it.thefedex87.footballbuddy.ui.theme.FootballBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootballBuddyTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                BottomNavigationScreen(navController = navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FootballBuddyTheme {

    }
}