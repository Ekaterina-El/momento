package ru.elkael.feature_authorization

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.elkael.ui.loaders.Loader
import ru.elkael.ui.dialogs.ExceptionDialog
import ru.elkael.resources.R
import ru.elkael.ui.button.ButtonType
import ru.elkael.ui.button.TextButtonState
import ru.elkael.ui.navigations.Screen
import ru.elkael.ui.theme.APP_VERTICAL_PADDING
import ru.elkael.ui.theme.AccentColor

@Composable
fun AuthorizationScreenController(
    viewModel: AuthorizationViewModel,
    onNavigate: (Screen) -> Unit
) {
    val state = viewModel.viewState.collectAsState(AuthorizationState.Initial)

    Scaffold { paddingValues ->
        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        when (val currentState = state.value) {
            AuthorizationState.Initial -> {}
            AuthorizationState.Loading -> Loader()
            AuthorizationState.SignIn, AuthorizationState.SignUp -> AuthorizationForm(
                state = state,
                viewModel = viewModel,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .padding(
                        horizontal = 60.dp,
                        vertical = APP_VERTICAL_PADDING
                    )
            )

            AuthorizationState.Authorized -> onNavigate(Screen.Home)

            is AuthorizationState.Exception -> {
                val exceptionMessage = when (currentState) {
                    AuthorizationState.Exception.Network -> stringResource(R.string.network_exception)
                    AuthorizationState.Exception.Unknown -> stringResource(R.string.auth_unknown_exception)
                    AuthorizationState.Exception.UserCollision -> stringResource(R.string.auth_user_collision_exception)
                }

                ExceptionDialog(
                    title = stringResource(R.string.something_went_wrong),
                    message = exceptionMessage,
                    TextButtonState(
                        text = stringResource(R.string.ok),
                        color = Color.White,
                        textColor = AccentColor,
                        type = ButtonType.CONTAINED,
                        onClickListener = viewModel::selectSignUp
                    )
                )
            }
        }
    }
}

