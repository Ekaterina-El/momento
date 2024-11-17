package ru.elkael.ui.dialogs

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.elkael.resources.R
import ru.elkael.ui.button.ButtonType
import ru.elkael.ui.button.TextButtonState

@Composable
fun ExceptionDialog(
    title: String,
    message: String,
    buttonState: TextButtonState
) {
    DialogWithDefaultButton(buttonState = buttonState) {
        Text(title, fontSize = 18.sp)
        Spacer(Modifier.height(30.dp))
        Text(message)
    }
}

@Preview
@Composable
private fun ExceptionDialogPreview() {
    ExceptionDialog(
        title = stringResource(R.string.something_went_wrong),
        message = stringResource(R.string.auth_unknown_exception),
        buttonState = TextButtonState(
            text = stringResource(R.string.ok),
            color = Color.White,
            type = ButtonType.CONTAINED
        )
    )
}