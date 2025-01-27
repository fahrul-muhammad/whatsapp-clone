package com.android.whatsappclone.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Archive
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.whatsappclone.R
import com.android.whatsappclone.model.chat.GetDataChat
import com.android.whatsappclone.ui.components.Chat
import com.android.whatsappclone.ui.components.Title
import com.android.whatsappclone.viewmodel.ChatViewModel

@Composable
fun ChatScreen(viewModel: ChatViewModel = hiltViewModel<ChatViewModel>()) {
    ChatScreenContent(getDataChat = viewModel::onGetListChat)
}

@Composable
fun ChatScreenContent(modifier: Modifier = Modifier, getDataChat: () -> Unit) {
    var scrollState = rememberScrollState(initial = 0)

    LaunchedEffect(Unit) {
        getDataChat()
    }

    Column(
        modifier = modifier
            .background(Color.Black)

    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(horizontal = 12.dp)
                .verticalScroll(scrollState)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(35.dp)
                ,
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Title(text = stringResource(R.string.whatsapp))
                Row(
                ) {
                    IconButton(
                        onClick = {},
                        colors = IconButtonColors(
                            contentColor = Color.White,
                            containerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor = Color.White
                        )
                    ) {
                        Icon(Icons.Outlined.PhotoCamera, contentDescription = null)
                    }
                    IconButton(
                        onClick = {},
                        colors = IconButtonColors(
                            contentColor = Color.White,
                            containerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            disabledContentColor = Color.White
                        )
                    ) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                }
            }
            Spacer(modifier = modifier.height(20.dp))
            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Text(text = stringResource(R.string.tanya_atau_cari), color = Color.Gray, fontSize = 15.sp)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .border(
                        border = BorderStroke(
                            width = 0.dp,
                            color = Color.Transparent
                        )
                    )
                ,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = colorResource(R.color.grey),
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = colorResource(R.color.grey),
                    cursorColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent, // to remove the default border
                    focusedIndicatorColor = Color.Transparent // to remove the default border
                ),
                shape = RoundedCornerShape(28.dp),
                leadingIcon = {
                    IconButton(onClick = {  }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = Color.White
                        )
                    }
                },

                singleLine = true
            )
            Spacer(modifier = modifier.height(10.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(35.dp).clickable(
                        onClick = {}
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.width(120.dp)
                ) {
                    Icon(Icons.Outlined.Archive, contentDescription = null, tint = Color.White)
                    Text(text = stringResource(R.string.arsip), color = Color.White,fontWeight = FontWeight.W700, fontSize = 18.sp)
                }
                Text(text = "1", color = colorResource(R.color.green), fontWeight = FontWeight.W700)
            }
            Spacer(Modifier.height(10.dp))
            for (x in 1..20){
            Chat()
            if(x == 20){
                Spacer(modifier = modifier.height(100.dp))
            }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ChatScreenContentPreview() {
    ChatScreenContent(getDataChat = {})
}