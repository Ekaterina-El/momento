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
import ru.elkael.momento.di.getApplicationComponent
import ru.elkael.ui.navigations.Screen
import ru.elkael.ui.theme.MomentoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModelFactory = getApplicationComponent().getViewModelFactory()

            MomentoTheme {
                val mainViewModel: MainViewModel = viewModel(factory = viewModelFactory)

                val state = mainViewModel.viewState.collectAsState()
                when (state.value) {
                    MainViewModelState.Initial -> mainViewModel.onNavigateTo(Screen.Authorization)
                    MainViewModelState.Home -> HomeScreenController()
                    MainViewModelState.Authorization -> {
                        AuthorizationScreenController(
                            viewModelFactory = viewModelFactory,
                            onNavigate = mainViewModel::onNavigateTo
                        )
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
