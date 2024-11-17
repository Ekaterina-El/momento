package ru.elkael.momento.di

import dagger.Binds
import dagger.Module
import ru.elkael.auth_domain.AuthRepository
import ru.elkael.firebase_auth_data.di.AuthorizationComponent
import ru.elkael.firebase_auth_data.repository.FirebaseAuthRepository

/**
 * Модуль содержащий перечень подкомпонент
 */
@Module(subcomponents = [AuthorizationComponent::class])
interface SubcomponentModule {
    @Binds
    fun bindAuthRepository(impl: FirebaseAuthRepository): AuthRepository
}
