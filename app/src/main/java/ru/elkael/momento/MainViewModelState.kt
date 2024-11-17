package ru.elkael.momento

import ru.elkael.ui.ViewState

sealed class MainViewModelState: ViewState {
    data object Initial: MainViewModelState()
    data object Authorization: MainViewModelState()
    data object Home: MainViewModelState()
}