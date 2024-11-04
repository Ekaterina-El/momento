package ru.elkael.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val fontFamily by lazy { Font.playWrite }

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val TextFieldTextStyle by lazy {
    TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold
    )
}

val TextFieldErrorTextStyle by lazy {
    TextStyle(
        fontFamily = fontFamily,
        fontSize = 12.sp,
        color = Error
    )
}

val ButtonMediumTextStyle by lazy {
    TextStyle(
        fontFamily = fontFamily,
        fontSize = 14.sp,
    )
}

val ButtonTextStyle by lazy {
    TextStyle(
        fontFamily = fontFamily,
        fontSize = 18.sp,
    )
}

val H1TextStyle by lazy {
    TextStyle(
        fontFamily = Font.smooch,
        fontSize = 48.sp,
    )
}