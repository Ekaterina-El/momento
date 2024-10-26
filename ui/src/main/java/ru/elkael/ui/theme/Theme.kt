package ru.elkael.ui.theme

import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    secondary = Color.White,
    tertiary = Color.White
)

@Composable
fun MomentoTheme(content: @Composable () -> Unit) {
    val context = LocalContext.current
    val window = (context as? ComponentActivity)?.window
    val view = LocalView.current

    window?.let {
        WindowCompat.setDecorFitsSystemWindows(it, false)
        val controller = WindowInsetsControllerCompat(it, view)
        controller.isAppearanceLightStatusBars = false
        controller.isAppearanceLightNavigationBars = false
    }

    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}