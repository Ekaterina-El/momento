package ru.elkael.ui.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.outlinedButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.elkael.ui.theme.AccentColor

@Composable
fun AppOutlineTextButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    state: TextButtonState,
) {
    OutlinedButton(
        enabled = state.enabled,
        modifier = modifier.defaultMinSize(52.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
        colors = outlinedButtonColors(
            containerColor = White,
        ),
        onClick = state.onClickListener,
        border = BorderStroke(1.dp, state.color ?: AccentColor),
        shape = MaterialTheme.shapes.large,
    ) {
        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = state.text,
            modifier = Modifier,
            color = state.color ?: AccentColor,
        )
    }
}

@Composable
@Preview
fun AppOutlineTextButton_Preview() {
    AppOutlineTextButton(
        state = TextButtonState(
            text = "Назад",
            type = ButtonType.CONTAINED,
        ),
    )
}
