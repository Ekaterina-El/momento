package ru.elkael.momento.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
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