package ru.elkael.utils

const val PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$ %^&*-]).{8,}\$"
const val EMAIL_PATTERN = "[^@ \t\r\n]+@[^@ \t\r\n]+\\.[^@ \t\r\n]+"
const val LOGIN_PATTERN = "^[A-Za-z0-9_]{3,15}\$"