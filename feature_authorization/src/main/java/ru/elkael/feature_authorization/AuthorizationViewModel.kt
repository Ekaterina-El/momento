package ru.elkael.feature_authorization

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.elkael.auth_domain.AuthStatus
import ru.elkael.auth_domain.useCase.CreateAccountUseCase
import ru.elkael.auth_domain.useCase.IsAuthedUseCase
import ru.elkael.ui.BaseViewModel
import javax.inject.Inject

class AuthorizationViewModel @Inject constructor(
    private val createAccountUseCase: CreateAccountUseCase,
    private val isAuthedUseCase: IsAuthedUseCase
): BaseViewModel<AuthorizationState>() {
    override fun createInitialState(): AuthorizationState = AuthorizationState.SignUp

    init {
        // TODO: check auth
    }

    fun selectSignUp() {
        setState(AuthorizationState.SignUp)
    }

    fun selectSignIn() {
        setState(AuthorizationState.SignIn)
    }

    fun createAccount(login: String, email: String, password: String) {
        setState(AuthorizationState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val state = createAccountUseCase(login = login, email = email, password = password)
            when (state) {
                AuthStatus.Success -> setState(AuthorizationState.Authorized)
                AuthStatus.UserCollisionException -> setState(AuthorizationState.Exception.UserCollision)
                AuthStatus.NetworkException -> setState(AuthorizationState.Exception.Network)
                else -> setState(AuthorizationState.Exception.Unknown)
            }
        }
    }

    fun login(email: String, password: String) {
        // TODO: try login
    }

    companion object {
        const val TAG = "AuthorizationViewModel"
    }
}

