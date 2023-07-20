package com.raj.trailer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raj.presentation.favorite.FavoriteScreen
import com.raj.presentation.home.HomeScreen
import com.raj.trailer.navigation.AppBottomNavigation
import com.raj.trailer.navigation.BottomNavigationScreens
import com.raj.trailer.navigation.bottomNavigationItems
import com.raj.presentation.ui.theme.TrailerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailerTheme {
                MainActivityScreen()
            }
        }
    }
}

@Preview
@Composable
private fun MainActivityScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            AppBottomNavigation(navController, bottomNavigationItems)
        },
    ) {
        it.calculateBottomPadding()
        MainScreenNavigationConfigurations(navController)
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavigationScreens.HomeScreen.route) {
        composable(BottomNavigationScreens.HomeScreen.route) {
            HomeScreen()
        }
        composable(BottomNavigationScreens.FavoriteScreen.route) {
            FavoriteScreen()
        }
    }
}