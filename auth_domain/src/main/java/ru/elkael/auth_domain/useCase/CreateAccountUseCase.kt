package ru.elkael.auth_domain.useCase

import ru.elkael.auth_domain.AuthRepository
import javax.inject.Inject

class CreateAccountUseCase @Inject constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, login: String, password: String) = repository.createAccount(
        email = email,
        login = login,
        password = password
    )
}