package ru.elkael.feature_authorization

import ru.elkael.ui.ViewState

/** Состояния экрана авторизации */
sealed class AuthorizationState: ViewState {
    data object Initial: AuthorizationState()
    data object Loading: AuthorizationState()
    data object SignIn: AuthorizationState()
    data object SignUp: AuthorizationState()
    data object Authorized: AuthorizationState()

    sealed class Exception: AuthorizationState() {
        data object UserCollision: Exception()
        data object Network: Exception()
        data object Unknown: Exception()
    }
}