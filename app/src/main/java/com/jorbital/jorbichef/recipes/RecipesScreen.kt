package com.jorbital.jorbichef.recipes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecipesScreen(viewModel: RecipesViewModel) {
    viewModel.testFirestore()
    Text("Recipes screen")
}
