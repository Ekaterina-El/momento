package ru.elkael.ui.button

import androidx.compose.ui.graphics.Color


data class TextButtonState(
    val text: String,
    val enabled: Boolean = true,
    val color: Color? = null,
    val textColor: Color? = null,
    val onClickListener: () -> Unit = {},
    val type: ButtonType,
)