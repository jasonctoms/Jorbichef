package com.jorbital.jorbichef

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.jorbital.jorbichef.design.JorbichefTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JorbichefTheme {
                MainScreen()
            }
        }
    }
}
