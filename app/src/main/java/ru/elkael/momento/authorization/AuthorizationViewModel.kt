package ru.elkael.momento.authorization

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthorizationViewModel: ViewModel() {
    private val _viewState = MutableStateFlow<AuthorizationState>(AuthorizationState.Initial)
    val viewState = _viewState.asStateFlow()

    init {
        _viewState.value = AuthorizationState.SignUp
    }

    fun selectSignUp() {
        _viewState.value = AuthorizationState.SignUp
    }

    fun selectSignIn() {
        _viewState.value = AuthorizationState.SignIn
    }

    fun createAccount(login: String, email: String, password: String) {
        // TODO: check data
        // TODO: check already created account
        // TODO: try create account
        // TODO: add user in DB
    }

    fun login(email: String, password: String) {
        // TODO: try login
    }
}

