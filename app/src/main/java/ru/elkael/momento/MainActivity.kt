package ru.elkael.momento

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.elkael.feature_authorization.AuthorizationScreenController
import ru.elkael.feature_authorization.AuthorizationViewModel
import ru.elkael.ui.navigations.Screen
import ru.elkael.ui.theme.MomentoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MomentoTheme {
                val mainViewModel: MainViewModel = viewModel()

                val state = mainViewModel.viewState.collectAsState()
                when (state.value) {
                    MainViewModelState.Initial -> {
                        mainViewModel.onNavigateTo(Screen.Authorization)
                    }

                    MainViewModelState.Authorization -> {
                        val authViewModel: AuthorizationViewModel = viewModel()
                        AuthorizationScreenController(
                            viewModel = authViewModel,
                            onNavigate = mainViewModel::onNavigateTo
                        )
                    }

                    MainViewModelState.Home -> {
                        HomeScreenController()
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreenController() {
    Text("HOME")
}
