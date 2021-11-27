package com.jorbital.jorbichef.start

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jorbital.jorbichef.R
import com.jorbital.jorbichef.grocerylist.GroceryListScreen
import com.jorbital.jorbichef.recipes.RecipesScreen
import com.jorbital.jorbichef.weeklymenu.WeeklyMenuScreen
import com.jorbital.jorbichef.weeklymenu.WeeklyMenuViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomNavigationItems = listOf(
        BottomNavigationScreens.WeeklyMenu,
        BottomNavigationScreens.GroceryList,
        BottomNavigationScreens.Recipes
    )
    Scaffold(
        topBar = {
            TopAppBar {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 16.dp)
                )
            }
        },
        bottomBar = {
            JorbichefBottomNavigation(navController, bottomNavigationItems)
        },
    ) {
        MainScreenNavigationConfigurations(navController)
    }
}

@Composable
private fun JorbichefBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = stringResource(id = screen.resourceId)
                    )
                },
                label = { Text(stringResource(id = screen.resourceId)) },
                selected = currentRoute == screen.route,
                alwaysShowLabel = false,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationRoute!!) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavigationScreens.WeeklyMenu.route) {
        composable(BottomNavigationScreens.WeeklyMenu.route) {
            val viewModel = getViewModel<WeeklyMenuViewModel>()
            WeeklyMenuScreen(viewModel)
        }
        composable(BottomNavigationScreens.GroceryList.route) {
            GroceryListScreen()
        }
        composable(BottomNavigationScreens.Recipes.route) {
            RecipesScreen()
        }
    }
}
