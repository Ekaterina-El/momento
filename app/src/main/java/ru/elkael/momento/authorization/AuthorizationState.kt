package ru.elkael.momento.authorization

/** Состояния экрана авторизации */
sealed class AuthorizationState {
    data object Initial: AuthorizationState()
    data object SignIn: AuthorizationState()
    data object SignUp: AuthorizationState()
}