package com.jorbital.jorbichef.start

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.jorbital.jorbichef.R
import com.jorbital.jorbichef.grocerylist.GroceryListScreen
import com.jorbital.jorbichef.recipes.RecipesScreen
import com.jorbital.jorbichef.recipes.RecipesViewModel
import com.jorbital.jorbichef.weeklymenu.WeeklyMenuScreen
import com.jorbital.jorbichef.weeklymenu.WeeklyMenuViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    val navController = rememberNavController()
    val openDialog = remember { mutableStateOf(false) }
    val bottomNavigationItems = listOf(
        BottomNavigationScreens.WeeklyMenu,
        BottomNavigationScreens.GroceryList,
        BottomNavigationScreens.Recipes
    )
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                actions = {
                    AsyncImage(
                        model = viewModel.currentUser?.photoUrl,
                        placeholder = painterResource(id = R.drawable.ic_account_circle),
                        fallback = painterResource(id = R.drawable.ic_account_circle),
                        contentDescription = stringResource(R.string.content_description_options_menu),
                        modifier = Modifier
                            .padding(end = 16.dp, start = 16.dp, top = 2.dp, bottom = 2.dp)
                            .clip(CircleShape)
                            .size(width = 32.dp, height = 32.dp)
                            .clickable {
                                openDialog.value = true
                            }
                    )
                }
            )
        },
        bottomBar = {
            JorbichefBottomNavigation(navController, bottomNavigationItems)
        },
    ) {
        if (openDialog.value) {
            AlertDialog(
                confirmButton = { },
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = stringResource(id = R.string.options_menu_title))
                },
                text = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {

                                }) {
                            Icon(Icons.Default.CloudDownload, contentDescription = null)
                            Spacer(modifier = Modifier.size(24.dp))
                            Text(stringResource(id = R.string.options_menu_sync))
                        }
                    }
                },
            )
        }
        MainScreenNavigationConfigurations(navController)
    }
}

@Composable
private fun JorbichefBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { screen ->
            NavigationBarItem(
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
            val viewModel = getViewModel<RecipesViewModel>()
            RecipesScreen(viewModel)
        }
    }
}
