package com.android.whatsappclone.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true,)
fun Title(modifier: Modifier = Modifier, text:String = "HelloWorld") {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 30.sp,
        fontWeight = FontWeight.W700,
        color = Color.White
    )
}