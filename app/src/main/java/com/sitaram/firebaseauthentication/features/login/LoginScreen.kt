package com.sitaram.firebaseauthentication.features.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sitaram.firebaseauthentication.features.TextComponent

@Preview
@Composable
fun LoginViewScreen() {
    Surface(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,) {
            TextComponent(text = "Login your details", color = Color.DarkGray)
        }
    }
}