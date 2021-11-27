package com.jorbital.jorbichef

import com.jorbital.jorbichef.weeklymenu.WeeklyMenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appKoinModule = module {
    viewModel { WeeklyMenuViewModel() }
}