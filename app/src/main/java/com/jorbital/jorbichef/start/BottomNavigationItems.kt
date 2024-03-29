package com.jorbital.jorbichef.start

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.ui.graphics.vector.ImageVector
import com.jorbital.jorbichef.R

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object WeeklyMenu :
        BottomNavigationScreens(
            route = "WeeklyMenu",
            resourceId = R.string.bottom_nav_weekly_menu,
            icon = Icons.Default.Restaurant
        )

    object GroceryList : BottomNavigationScreens(
        route = "GroceryList",
        resourceId = R.string.bottom_nav_grocery_list,
        icon = Icons.Default.List
    )

    object Recipes :
        BottomNavigationScreens(
            route = "Recipes",
            resourceId = R.string.bottom_nav_recipes,
            icon = Icons.Default.MenuBook
        )
}
