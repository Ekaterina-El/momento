package ru.elkael.feature_authorization

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.elkael.auth_domain.AuthRepository
import ru.elkael.auth_domain.AuthStatus
import ru.elkael.auth_domain.useCase.CreateAccountUseCase
import ru.elkael.auth_domain.useCase.IsAuthedUseCase
import ru.elkael.auth_domain.useCase.LogoutUseCase
import ru.elkael.firebase_auth_data.FirebaseAuthRepository
import ru.elkael.ui.BaseViewModel

class AuthorizationViewModel: BaseViewModel<AuthorizationState>() {
    private val authRepository: AuthRepository = FirebaseAuthRepository()
    private val createAccountUseCase: CreateAccountUseCase = CreateAccountUseCase(authRepository)
    private val isAuthedUseCase: IsAuthedUseCase = IsAuthedUseCase(authRepository)
    private val logoutUseCase: LogoutUseCase = LogoutUseCase(authRepository)

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

