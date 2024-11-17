package ru.elkael.auth_domain.useCase

import ru.elkael.auth_domain.AuthRepository
import javax.inject.Inject

class IsAuthedUseCase @Inject constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.isAuthed()
}