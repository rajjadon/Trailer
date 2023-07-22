package com.raj.trailer.navigation

import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.raj.common.constant.FAVORITE_SCREEN
import com.raj.common.constant.HOME_SCREEN
import com.raj.trailer.R

sealed class BottomNavigationScreens(
    val route: String, @StringRes val resourceId: Int, val icon: ImageVector
) {
    object HomeScreen :
        BottomNavigationScreens(HOME_SCREEN, R.string.home_screen, Icons.Filled.Home)

    object FavoriteScreen :
        BottomNavigationScreens(FAVORITE_SCREEN, R.string.favorite_screen, Icons.Filled.Favorite)
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
                    item.icon,
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