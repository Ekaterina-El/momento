package ru.elkael.ui.navigations

sealed class Screen {
    data object Authorization: Screen()
    data object Home: Screen()
}