package com.sitaram.firebaseauthentication.features.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TextComponent(text: String, color: Color) {
    Text(
        text = text,
        modifier = Modifier
            .wrapContentHeight()
            .padding(top = 5.dp),  // Specify the desired padding value
        style = TextStyle(
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun NavigationTextComponent(value: String, navController: NavController, route: String) {

    ClickableText(
        text = AnnotatedString(value),
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 5.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        ),
        onClick = {
            navController.navigate(route)
        }
    )
}


@Composable
fun TextFieldComponent(
    value: String,
    onValueChange: (String) -> Unit = {},
    painter: Painter,
    text: String
) {
    if (value.isEmpty()) {
        Text(
            text = "Enter the valid $text",
            color = Color.Red,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = text) },
        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = null
            ) // painterResource(id = R.drawable.ic_person)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(
                color = Color.White
            ),
    )
}

@Composable
fun ButtonComponent(onClick: () -> Unit = {}, btnText: String) {
    // normal button
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red) // Change the button color here
    ) {
        androidx.compose.material.Text(
            fontSize = 20.sp,
            text = btnText,
            fontWeight = FontWeight.SemiBold,
        )
    }
}