package com.raj.trailer.navigation

import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.raj.trailer.R
import com.raj.presentation.base.FAVORITE_SCREEN
import com.raj.presentation.base.HOME_SCREEN

sealed class BottomNavigationScreens(
    val route: String, @StringRes val resourceId: Int, val icon: Int
) {
    object HomeScreen : BottomNavigationScreens(HOME_SCREEN, R.string.home_screen, R.drawable.home)

    object FavoriteScreen :
        BottomNavigationScreens(FAVORITE_SCREEN, R.string.favorite_screen, R.drawable.bookmark)
}

val bottomNavigationItems = listOf(
    BottomNavigationScreens.HomeScreen, BottomNavigationScreens.FavoriteScreen
)

@Composable
fun AppBottomNavigation(
    navController: NavHostController, items: List<BottomNavigationScreens>
) {
    BottomNavigation(
        backgroundColor = Color.Gray, contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(icon = {
                Icon(
                    painterResource(id = item.icon),
                    contentDescription = item.route
                )
            },
                label = {
                    Text(
                        text = stringResource(id = item.resourceId), fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}