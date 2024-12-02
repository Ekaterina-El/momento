package ru.elkael.firebase_auth_data.repository

import com.google.firebase.Firebase
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await
import ru.elkael.auth_domain.AuthRepository
import ru.elkael.auth_domain.AuthStatus
import ru.elkael.auth_domain.entities.User
import javax.inject.Inject

class FirebaseAuthRepository @Inject constructor(): AuthRepository {
    private val auth: FirebaseAuth = Firebase.auth
    private val db: FirebaseFirestore = Firebase.firestore
    private val usersCollection by lazy { db.collection(USERS_COLLECTION) }

    override suspend fun createAccount(login: String, email: String, password: String): AuthStatus {
        val createUserResult = try {
             auth.createUserWithEmailAndPassword(email, password).await()
        } catch (e: FirebaseAuthUserCollisionException) {
            return AuthStatus.UserCollisionException
        } catch (e: FirebaseNetworkException) {
            return AuthStatus.NetworkException
        } catch (e: Exception) {
            return AuthStatus.UnknownException
        }

        val user = createUserResult.user ?: return AuthStatus.UnknownException
        val userData = User(uid = user.uid, email = email, login = login)
        usersCollection.document(user.uid).set(userData).await()

        return AuthStatus.Success
    }

    override suspend fun login(email: String, password: String): AuthStatus {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            return AuthStatus.Success
        } catch (e: FirebaseNetworkException) {
            AuthStatus.NetworkException
        } catch (e: Exception) {
            AuthStatus.UnknownException
        }
    }

    override fun logout() = auth.signOut()

    override fun isAuthed(): Boolean = auth.currentUser != null

    companion object {
        private const val TAG = "FirebaseAuthRepository"
        private const val USERS_COLLECTION = "users"
    }
}