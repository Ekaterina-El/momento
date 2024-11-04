package ru.elkael.auth_domain

interface AuthRepository {
    suspend fun createAccount(login: String, email: String, password: String): AuthStatus
    fun isAuthed(): Boolean
    fun logout()
}