package com.sitaram.firebaseauthentication.features

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(text: String, color: Color) {
    Text(
        text = text,
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 5.dp),  // Specify the desired padding value
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Normal
        ),
        textAlign = TextAlign.Center,
        color = color
    )
}