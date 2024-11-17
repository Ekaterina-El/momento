package ru.elkael.ui.input

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.elkael.ui.theme.LightGray
import ru.elkael.ui.theme.TextFieldErrorTextStyle
import ru.elkael.ui.theme.TextFieldTextStyle


@Composable
fun AppTextField(
    modifier: Modifier = Modifier.fillMaxWidth(),
    value: String,
    isValid: Boolean = true,
    errorText: String = "Invalid",
    color: Color = MaterialTheme.colorScheme.onBackground,
    placeholderColor: Color = LightGray,
    placeholder: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    onValueChange: (String) -> Unit = {},
) {
    Column(modifier = modifier) {
        BasicTextField(
            modifier = Modifier.fillMaxWidth().height(30.dp),
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = keyboardOptions,
            textStyle = TextFieldTextStyle.copy(color = color),
            singleLine = true,
            cursorBrush = Brush.horizontalGradient(listOf(Color.White, Color.White)),
            maxLines = 1,
            decorationBox = { innerTextField ->
                Box(
                    modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (value.isEmpty() && placeholder != null)
                        Text(text = placeholder, style = TextFieldTextStyle.copy(color = placeholderColor))
                    innerTextField()
                }
            }
        )

        HorizontalDivider(
            color = color,
            thickness = 0.5.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            if (isValid) "" else errorText,
            style = TextFieldErrorTextStyle
        )
    }
}

@Preview
@Composable
fun AppTextFieldPreview() {
    MaterialTheme {
        AppTextField(
            value = "",
            placeholder = "Password",
            color = MaterialTheme.colorScheme.background,
        )
    }
}