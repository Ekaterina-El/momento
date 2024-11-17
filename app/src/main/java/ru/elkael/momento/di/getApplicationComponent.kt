package ru.elkael.momento.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import ru.elkael.momento.MomentoApplication

@Composable
fun getApplicationComponent(): ApplicationComponent {
    return (LocalContext.current.applicationContext as MomentoApplication).component
}