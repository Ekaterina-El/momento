package ru.elkael.feature_authorization

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.elkael.resources.R
import ru.elkael.ui.input.AppButton
import ru.elkael.ui.input.AppTextField
import ru.elkael.ui.theme.H1TextStyle
import ru.elkael.utils.ext.isValidEmail
import ru.elkael.utils.ext.isValidLogin
import ru.elkael.utils.ext.isValidPassword

@Composable
fun AuthorizationForm(
    modifier: Modifier,
    state: State<AuthorizationState>,
    viewModel: AuthorizationViewModel
) {
    var login by remember { mutableStateOf("") }
    val loginIsValid = login.isValidLogin()

    var email by remember { mutableStateOf("") }
    val emailIsValid = email.isValidEmail()

    var password by remember { mutableStateOf("") }
    val passwordIsValid = password.isValidPassword()

    val spaceBetweenFields = 20.dp
    val isSignUp = state.value == AuthorizationState.SignUp

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))

        val header = stringResource(R.string.app_name)
        Text(text = header, style = H1TextStyle)

        HorizontalDivider(
            color = Color.White,
            thickness = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            AppButton(
                isOutline = isSignUp,
                text = stringResource(R.string.sign_up),
                modifier = Modifier.weight(1f),
                onClick = viewModel::selectSignUp
            )
            Spacer(modifier = Modifier.width(15.dp))
            AppButton(
                isOutline = !isSignUp,
                text = stringResource(R.string.sign_in),
                modifier = Modifier.weight(1f),
                onClick = viewModel::selectSignIn
            )
        }

        Spacer(modifier = Modifier.height(45.dp))

        AppTextField(
            modifier = Modifier.alpha(if (isSignUp) 1f else 0f),
            value = login,
            errorText = stringResource(R.string.invalid_login),
            isValid = login.isEmpty() || loginIsValid,
            placeholder = stringResource(R.string.login_placeholder),
            onValueChange = { login = it }
        )

        Spacer(modifier = Modifier.height(spaceBetweenFields))

        AppTextField(
            value = email,
            isValid = email.isEmpty() || emailIsValid,
            errorText = stringResource(R.string.invalid_email),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            placeholder = stringResource(R.string.email_placeholder),
            onValueChange = { email = it }
        )

        Spacer(modifier = Modifier.height(spaceBetweenFields))

        AppTextField(
            value = password,
            isValid = password.isEmpty() || passwordIsValid,
            errorText = stringResource(R.string.weak_password),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = stringResource(R.string.password_placeholder),
            onValueChange = { password = it },
        )

        Spacer(modifier = Modifier.height(45.dp))

        if (isSignUp) {
            AppButton(
                text = stringResource(R.string.create_account),
                enabled = loginIsValid && emailIsValid && passwordIsValid
            ) { viewModel.createAccount(login, email, password) }
        } else {
            AppButton(
                text = stringResource(R.string.login),
                enabled = emailIsValid && passwordIsValid
            ) { viewModel.login(email, password) }
        }

        Spacer(Modifier.weight(1f))
    }
}
