package com.raj.trailer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raj.presentation.favorite.FavoriteScreen
import com.raj.presentation.favorite.FavoriteViewModel
import com.raj.presentation.home.HomeScreen
import com.raj.presentation.home.HomeViewModel
import com.raj.presentation.ui.theme.TrailerTheme
import com.raj.trailer.navigation.AppBottomNavigation
import com.raj.trailer.navigation.BottomNavigationScreens
import com.raj.trailer.navigation.bottomNavigationItems
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
        Box(modifier = Modifier.padding(it)) {
            MainScreenNavigationConfigurations(navController)
        }
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavigationScreens.HomeScreen.route) {
        composable(BottomNavigationScreens.HomeScreen.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            homeViewModel.getMovieList()
            HomeScreen(homeViewModel)
        }
        composable(BottomNavigationScreens.FavoriteScreen.route) {
            val favoriteViewModel: FavoriteViewModel = hiltViewModel()
            favoriteViewModel.getMovieList()
            FavoriteScreen(favoriteViewModel)
        }
    }
}