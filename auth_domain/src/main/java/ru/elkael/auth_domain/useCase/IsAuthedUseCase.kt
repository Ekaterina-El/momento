package ru.elkael.auth_domain.useCase

import ru.elkael.auth_domain.AuthRepository

class IsAuthedUseCase(private val repository: AuthRepository) {
    operator fun invoke() = repository.isAuthed()
}