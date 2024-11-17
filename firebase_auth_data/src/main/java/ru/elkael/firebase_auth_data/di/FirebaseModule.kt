package ru.elkael.firebase_auth_data.di

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides

@Module
interface FirebaseModule {
    companion object {
        @Provides
        fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth

        @Provides
        fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore
    }
}