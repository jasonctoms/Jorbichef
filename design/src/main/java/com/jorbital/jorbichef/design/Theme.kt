package com.jorbital.jorbichef.design

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = primaryGreen,
    primaryVariant = primaryGreenDark,
    secondary = secondaryBlue,
    secondaryVariant = secondaryBlueDark
)

private val LightColorPalette = lightColors(
    primary = primaryGreen,
    primaryVariant = primaryGreenDark,
    secondary = secondaryBlue,
    secondaryVariant = secondaryBlueDark

    /* Other default colors to override
background = Color.White,
surface = Color.White,
onPrimary = Color.White,
onSecondary = Color.Black,
onBackground = Color.Black,
onSurface = Color.Black,
*/
)

@Composable
fun JorbichefTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
