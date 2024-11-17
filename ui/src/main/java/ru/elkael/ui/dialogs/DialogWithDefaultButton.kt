package ru.elkael.ui.dialogs

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.elkael.ui.button.AppTextButton
import ru.elkael.ui.button.TextButtonState

@Composable
fun DialogWithDefaultButton(
    buttonState: TextButtonState,
    content: @Composable ColumnScope.() -> Unit,
) {
    DialogWrapper {
        content()
        Spacer(Modifier.height(22.dp))
        AppTextButton(state = buttonState)
    }
}
