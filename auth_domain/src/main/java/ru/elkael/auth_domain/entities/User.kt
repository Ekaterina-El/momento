package ru.elkael.auth_domain.entities

data class User(
    val uid: String,
    val email: String,
    val login: String,
    val categoriesID: List<String> = emptyList(),
    val memoriesID: List<String> = emptyList(),
)
