package ru.elkael.momento.di

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import ru.elkael.auth_domain.AuthRepository
import ru.elkael.firebase_auth_data.repository.FirebaseAuthRepository
import ru.elkael.momento.ViewModelFactory

@AppScope
@Component(
    modules = [
        SubcomponentModule::class,
        ViewModelModule::class,
    ]
)
interface ApplicationComponent {
    fun getViewModelFactory(): ViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}