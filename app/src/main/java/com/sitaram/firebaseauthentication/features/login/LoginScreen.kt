package com.sitaram.firebaseauthentication.features.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LoginViewScreen() {
    Surface(Modifier.fillMaxSize()) {
        Column {
            Text(text = "Login your details")
        }
    }
}