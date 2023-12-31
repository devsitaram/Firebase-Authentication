package com.sitaram.firebaseauthentication.features.data

import com.google.firebase.auth.AuthResult
import com.sitaram.firebaseauthentication.features.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>
}