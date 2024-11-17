package ru.elkael.feature_authorization

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.elkael.auth_domain.AuthStatus
import ru.elkael.auth_domain.useCase.CreateAccountUseCase
import ru.elkael.auth_domain.useCase.IsAuthedUseCase
import ru.elkael.auth_domain.useCase.LoginUseCase
import ru.elkael.ui.BaseViewModel
import javax.inject.Inject

class AuthorizationViewModel @Inject constructor(
    private val createAccountUseCase: CreateAccountUseCase,
    private val loginUseCase: LoginUseCase,
    private val isAuthedUseCase: IsAuthedUseCase
): BaseViewModel<AuthorizationState>() {
    override fun createInitialState(): AuthorizationState = AuthorizationState.SignUp

    private var currentAuthPart: AuthPart = AuthPart.CREATE_ACCOUNT

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
        Log.i(TAG, "[processState] Create account with email $email and login $login")
        setState(AuthorizationState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            currentAuthPart = AuthPart.CREATE_ACCOUNT
            val state = createAccountUseCase(login = login, email = email, password = password)
            processState(state)
        }
    }

    fun login(email: String, password: String) {
        Log.i(TAG, "[processState] Login with email $email")
        setState(AuthorizationState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            currentAuthPart = AuthPart.LOGIN
            val state = loginUseCase(email = email, password = password)
            processState(state)
        }
    }

    private fun processState(state: AuthStatus) {
        Log.i(TAG, "[processState] State: $state")
        when (state) {
            AuthStatus.Success -> setState(AuthorizationState.Authorized)
            AuthStatus.UserCollisionException -> setState(AuthorizationState.Exception.UserCollision)
            AuthStatus.NetworkException -> setState(AuthorizationState.Exception.Network)
            else -> setState(AuthorizationState.Exception.Unknown)
        }
    }

    companion object {
        const val TAG = "AuthorizationViewModel"
    }

    private enum class AuthPart { LOGIN, CREATE_ACCOUNT }
}
