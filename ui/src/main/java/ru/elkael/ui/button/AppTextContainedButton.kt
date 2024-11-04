package ru.elkael.ui.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import ru.elkael.ui.theme.AccentColor
import ru.elkael.ui.theme.ButtonMediumTextStyle
import ru.elkael.ui.theme.Neutral400

@Composable
fun AppTextContainedButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    state: TextButtonState,
) {
    Button(
        enabled = state.enabled,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
        modifier = modifier.defaultMinSize(52.dp),
        onClick = state.onClickListener,
        colors = ButtonDefaults.buttonColors(
            containerColor = state.color ?: AccentColor,
            disabledContainerColor = Neutral400,
        ),
        shape = MaterialTheme.shapes.large,
        contentPadding = PaddingValues(
            start = 4.dp,
            top = 8.dp,
            end = 4.dp,
            bottom = 8.dp,
        ),
    ) {
        Text(
            style = ButtonMediumTextStyle,
            text = state.text,
            modifier = Modifier,
            color = state.textColor ?: White,
        )
    }
}
