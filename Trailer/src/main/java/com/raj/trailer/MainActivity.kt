package com.raj.trailer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raj.trailer.base.HOME_SCREEN
import com.raj.trailer.home.HomeScreen
import com.raj.trailer.ui.theme.TrailerTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrailerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    navHostController = rememberNavController()

                    NavHost(navController = navHostController, startDestination = HOME_SCREEN) {
                        composable(HOME_SCREEN) {
                            HomeScreen()
                        }
//                        composable(FAVORITE_SCREEN) {
//                            AddProjectScreen()
//                        }
                    }
                }
            }
        }
    }
}