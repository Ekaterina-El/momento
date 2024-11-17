package ru.elkael.momento

import android.app.Application
import ru.elkael.momento.di.ApplicationComponent
import ru.elkael.momento.di.DaggerApplicationComponent

class MomentoApplication: Application() {
    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}

