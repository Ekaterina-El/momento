package ru.elkael.auth_domain.useCase

import ru.elkael.auth_domain.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) = repository.login(
        email = email,
        password = password
    )
}