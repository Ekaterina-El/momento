package ru.elkael.ui.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.elkael.resources.R
import ru.elkael.ui.theme.ButtonTextStyle
import ru.elkael.ui.theme.MomentoTheme


@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    isOutline: Boolean = false,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit = {}
) {
    val shape = RoundedCornerShape(3.dp)

    if (isOutline) {
        OutlinedButton(
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
            modifier = modifier,
            shape = shape,
            enabled = enabled,
            elevation = null,
            onClick = onClick
        ) {
            Text(text, style = ButtonTextStyle.copy(color = MaterialTheme.colorScheme.onBackground))
        }
    } else {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
            ),
            modifier = modifier,
            shape = shape,
            elevation = null,
            enabled = enabled,
            onClick = onClick,
        ) {
            Text(text, style = ButtonTextStyle.copy(color = MaterialTheme.colorScheme.background))
        }
    }
}

@Preview
@Composable
private fun ButtonsPreview() {
    MomentoTheme {
        Row(modifier = Modifier.fillMaxWidth()) {
            AppButton(
                isOutline = true,
                text = stringResource(R.string.sign_in),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(15.dp))
            AppButton(
                text = stringResource(R.string.sign_up),
                modifier = Modifier.weight(1f)
            )
        }
    }
}