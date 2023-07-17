package com.sitaram.firebaseauthentication.features.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sitaram.firebaseauthentication.R
import com.sitaram.firebaseauthentication.features.util.ButtonComponent
import com.sitaram.firebaseauthentication.features.util.NavigationTextComponent
import com.sitaram.firebaseauthentication.features.util.TextComponent
import com.sitaram.firebaseauthentication.features.util.TextFieldComponent

@Preview
@Composable
fun LoginViewScreen() {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val onLoginClick: () -> Unit = {

    }

    Surface(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            TextComponent(text = "Login your details", color = Color.DarkGray)
            Spacer(modifier = Modifier.height(50.dp))

            Column {
                TextFieldComponent(
                    username,
                    onValueChange = { username = it },
                    painter = painterResource(id = R.drawable.ic_person),
                    text = "Username",
                )

                Spacer(modifier = Modifier.height(10.dp))
                TextFieldComponent(
                    password,
                    onValueChange = { password = it },
                    painter = painterResource(id = R.drawable.ic_lock),
                    text = "Password",
                )

                Spacer(modifier = Modifier.height(50.dp))
                // normal button
                ButtonComponent(onClick = onLoginClick, btnText = "Log In")
            }

            // divider
            Divider(Modifier.padding(top = 30.dp, start = 25.dp, end = 25.dp).fillMaxWidth().height(3.dp).background(Color.White))

            NavigationTextComponent(text = "Register your account?", color = Color.DarkGray)
        }
    }
}
