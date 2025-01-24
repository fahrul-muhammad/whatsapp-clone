package com.android.whatsappclone.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.whatsappclone.R
import com.android.whatsappclone.viewmodel.AuthViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel) {
    LoginScreenContent(
        navController = navController,
        isLoading = viewModel.isLoading.value,
        setUserName = viewModel::setUsername,
        setPassword = viewModel::setPassword,
        onLogin = viewModel::onLogin,
        username = viewModel.username.value,
        password = viewModel.password.value,
    )
}


@Composable
fun LoginScreenContent(modifier: Modifier = Modifier, navController: NavController, isLoading:Boolean = false, setUserName:(String) -> Unit, setPassword:(String) -> Unit, onLogin:() -> Unit, username:String, password:String) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
       verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .height(400.dp)
                .width(350.dp)
                .background(
                    color = Color.White
                )
                .border(
                    width = 1.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(2.dp)
                )
                .shadow(
                    elevation = 1.dp,
                    clip = false,
                    shape = RoundedCornerShape(2.dp),
                    ambientColor = Color.LightGray,
                    spotColor = Color.LightGray
                )
        ) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.green)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    Text(
                        text = stringResource(R.string.Login),
                        color = Color.White,
                        fontWeight = FontWeight.W700,
                        fontSize = 20.sp
                    )
                }
            }
            Spacer(modifier = modifier
                .height(10.dp)
            )
            OutlinedTextField(
                value = username,
                onValueChange = { setUserName(it)},
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                ,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = Color.Black,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedBorderColor = colorResource(R.color.green_chat),
                    focusedBorderColor = colorResource(R.color.green),
                    cursorColor = colorResource(R.color.green)
                )
                ,
                label = { Text(text = stringResource(R.string.email)) },
                keyboardActions = KeyboardActions.Default

            )
            Spacer(modifier = modifier
                .height(10.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = {setPassword(it)},
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                ,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = Color.Black,
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedBorderColor = colorResource(R.color.green_chat),
                    focusedBorderColor = colorResource(R.color.green),
                    cursorColor = colorResource(R.color.green)
                )
                ,
                label = { Text(text = stringResource(R.string.password)) },
                keyboardActions = KeyboardActions.Default,
                visualTransformation = if (!isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        Icon(
                            imageVector = if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (isPasswordVisible) "Hide password" else "Show password",
                            tint = colorResource(id = R.color.green)
                        )
                    }
                },
            )
            Spacer(modifier = modifier
                .height(20.dp)
            )
            Button(
                onClick = { onLogin() },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .height(45.dp)
                ,
                colors = ButtonColors(
                    colorResource(R.color.green),
                    contentColor = Color.White,
                    disabledContainerColor = colorResource(R.color.green_chat),
                    disabledContentColor = colorResource(R.color.green_chat)

                ),
            ) {
                if(!isLoading) {
                    Text(text = stringResource(R.string.Login))
                } else {
                    CircularProgressIndicator(
                        color = Color.White,
                        strokeWidth = 3.dp,
                        modifier = modifier
                            .width(20.dp)
                            .height(20.dp)
                    )
                }
            }
            Spacer(modifier = modifier
                .height(15.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                Row {
                    Text(text = stringResource(R.string.have_no_account), color = Color.Gray)
                }
            }

        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun LoginScreenContentPreview() {
    val navController = rememberNavController()
    LoginScreenContent(navController = navController, isLoading = false, setUserName = {}, setPassword = {}, onLogin = {}, username = "", password = "")
}