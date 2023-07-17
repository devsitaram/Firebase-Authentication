package com.sitaram.firebaseauthentication.features.login

data class LoginState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
