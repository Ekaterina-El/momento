package ru.elkael.momento

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.elkael.momento.authorization.AuthorizationScreen
import ru.elkael.ui.theme.MomentoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MomentoTheme {
                AuthorizationScreen()
            }
        }
    }
}