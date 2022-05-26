package com.jorbital.jorbichef.recipes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.getViewModel

@Composable
fun RecipesScreen(viewModel: RecipesViewModel = getViewModel()) {
    Text("Recipes screen")
}
