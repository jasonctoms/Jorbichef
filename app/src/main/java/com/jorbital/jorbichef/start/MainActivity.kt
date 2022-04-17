package com.jorbital.jorbichef.start

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.jorbital.jorbichef.design.JorbichefTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainScreenViewModel: MainScreenViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainScreenViewModel.initialSync()
        setContent {
            JorbichefTheme {
                MainScreen(mainScreenViewModel)
            }
        }
    }
}
