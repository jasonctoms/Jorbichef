package com.jorbital.jorbichef

import com.jorbital.jorbichef.recipes.RecipesViewModel
import com.jorbital.jorbichef.start.MainScreenViewModel
import com.jorbital.jorbichef.weeklymenu.WeeklyMenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appKoinModule = module {
    viewModel { WeeklyMenuViewModel() }
    viewModel { RecipesViewModel(get()) }
    viewModel { MainScreenViewModel(get()) }
}