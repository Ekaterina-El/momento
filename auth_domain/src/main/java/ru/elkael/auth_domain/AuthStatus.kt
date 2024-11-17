package ru.elkael.auth_domain

sealed class AuthStatus {
    data object UserCollisionException: AuthStatus()
    data object NetworkException: AuthStatus()
    data object UnknownException: AuthStatus()
    data object Success: AuthStatus()
}