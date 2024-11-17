package ru.elkael.ui.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.elkael.ui.theme.MomentoTheme

@Composable
fun AppTextButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    state: TextButtonState,
) {
    when (state.type) {
        ButtonType.CONTAINED -> AppTextContainedButton(modifier = modifier, state = state)
        ButtonType.OUTLINE -> AppOutlineTextButton(modifier = modifier, state = state)
    }
}

@Preview
@Composable
fun PreviewAppTextButtonOutline() {
    MomentoTheme {
        AppTextButton(
            state = TextButtonState(
                text = "Назад",
                type = ButtonType.OUTLINE,
            ),
        )
    }
}

@Preview
@Composable
fun PreviewAppTextButtonContained() {
    MomentoTheme {
        AppTextButton(
            state = TextButtonState(
                enabled = false,
                text = "Назад",
                type = ButtonType.CONTAINED,
            ),
        )
    }
}
