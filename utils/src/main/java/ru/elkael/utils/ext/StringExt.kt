package ru.elkael.utils.ext

import ru.elkael.utils.EMAIL_PATTERN
import ru.elkael.utils.LOGIN_PATTERN
import ru.elkael.utils.PASSWORD_PATTERN

private val loginRegex by lazy { Regex(LOGIN_PATTERN) }
private val emailRegex by lazy { Regex(EMAIL_PATTERN) }
private val passwordRegex by lazy { Regex(PASSWORD_PATTERN) }

/** Проверка является ли строка валидной почтой */
fun String.isValidEmail() = emailRegex.matches(this)


/**
 * Проверка является ли строка валидной почтой
 *
 * Условия:
 * - Длина от 3 до 15
 */
fun String.isValidLogin() = loginRegex.matches(this)


/**
 * Проверка является ли строка валидным паролем
 *
 * Условия:
 * - Минимум 8 символов
 * - По крайней мере одну букву верхнего регистра
 * - По крайней мере одну букву нижнего регистра
 * - По крайней мере одну цифру
 * - По крайней мере один специальный символ (например, @, #, $, и т. д.).
 */
fun String.isValidPassword() = passwordRegex.matches(this)
