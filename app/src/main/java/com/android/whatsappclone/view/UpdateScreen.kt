package com.android.whatsappclone.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UpdateScreen(modifier: Modifier = Modifier) {
    UpdateScreenContent()
}

@Composable
fun UpdateScreenContent(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = "Update Screen")
    }
}

@Preview(showSystemUi = true)
@Composable
private fun UpdateScreenContentPreview() {
    UpdateScreenContent()
}