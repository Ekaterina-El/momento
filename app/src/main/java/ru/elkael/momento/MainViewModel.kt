package ru.elkael.momento

import ru.elkael.ui.navigations.Screen
import ru.elkael.ui.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(): BaseViewModel<MainViewModelState>() {
    override fun createInitialState(): MainViewModelState = MainViewModelState.Initial

    fun onNavigateTo(screen: Screen) {
        when (screen) {
            Screen.Authorization -> setState(MainViewModelState.Authorization)
            Screen.Home -> setState(MainViewModelState.Home)
        }
    }
}