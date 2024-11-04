package ru.elkael.auth_domain.useCase

import ru.elkael.auth_domain.AuthRepository

class LogoutUseCase(private val repository: AuthRepository) {
    operator fun invoke() = repository.logout()
}