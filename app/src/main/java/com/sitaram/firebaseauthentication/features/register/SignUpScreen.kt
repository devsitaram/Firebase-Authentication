package com.sitaram.firebaseauthentication.features.register

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sitaram.firebaseauthentication.R
import com.sitaram.firebaseauthentication.features.util.ButtonComponent
import com.sitaram.firebaseauthentication.features.util.NavigationTextComponent
import com.sitaram.firebaseauthentication.features.util.TextComponent
import com.sitaram.firebaseauthentication.features.util.TextFieldComponent
import kotlinx.coroutines.launch

@Composable
fun SignUpViewScreen(navController: NavHostController) {

    val viewModel: SignUpViewModel = hiltViewModel()
    val state = viewModel.signUpState.collectAsState(initial = null)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    var email by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val onLoginClick: () -> Unit = {
        scope.launch {
            viewModel.registerUser(email, password)
        }
//        val registerSuccess = true
//
//        if (registerSuccess){
//            navController.navigate("Login")
//        }
    }

    Surface(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Spacer(modifier = Modifier.height(50.dp))
            TextComponent(text = "Register your details", color = Color.DarkGray)
            Spacer(modifier = Modifier.height(50.dp))

            Column {
                TextFieldComponent(
                    email,
                    onValueChange = { email = it },
                    painter = painterResource(id = R.drawable.ic_email),
                    text = "Email",
                )

                Spacer(modifier = Modifier.height(10.dp))
                TextFieldComponent(
                    name,
                    onValueChange = { name = it },
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
                ButtonComponent(onClick = onLoginClick, btnText = "Sign Up")

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    if(state.value?.isLoading == true){
                        CircularProgressIndicator()
                    }
                }
            }
            // divider
            Divider(
                Modifier
                    .padding(top = 30.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(Color.White)
            )

            NavigationTextComponent("Login your account?", navController, "Login")
        }

        // success
        LaunchedEffect(key1 = state.value?.isSuccess){
            scope.launch {
                if (state.value?.isSuccess?.isNotEmpty() == null){
                    val success = state.value?.isSuccess
                    // toast message
                    Toast.makeText(context, "$success", Toast.LENGTH_SHORT).show()
                    
                }
            }
        }

        // error
        LaunchedEffect(key1 = state.value?.isError){
            scope.launch {
                if (state.value?.isError?.isNotEmpty() == null){
                    val error = state.value?.isError
                    // toast message
                    Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}