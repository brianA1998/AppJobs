package com.example.appjobs.domain.auth

import com.example.appjobs.data.remote.auth.AuthDataSource
import com.google.firebase.auth.FirebaseUser

class AuthRepoImpl(private val dataSource: AuthDataSource) : AuthRepo {

    override suspend fun signIn(email: String, password: String): FirebaseUser? {
        return dataSource.signIn(email, password)
    }

    override suspend fun signUp(email: String, password: String, username: String): FirebaseUser? {
        return dataSource.signUp(email, password , username)
    }
}