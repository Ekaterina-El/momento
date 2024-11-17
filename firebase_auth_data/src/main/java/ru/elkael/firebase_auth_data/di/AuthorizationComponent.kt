package ru.elkael.firebase_auth_data.di

import dagger.Subcomponent

@Subcomponent(
    modules = [
        FirebaseModule::class
    ]
)
interface AuthorizationComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthorizationComponent
    }
}