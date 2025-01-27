package com.android.whatsappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.whatsappclone.model.RouterScreen
import com.android.whatsappclone.view.LoginScreen
import com.android.whatsappclone.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = RouterScreen.LOGIN_SCREEN
            ){
                composable(RouterScreen.LOGIN_SCREEN){
                    val viewModel = hiltViewModel<AuthViewModel>()
                    LoginScreen(navController = navController, viewModel = viewModel)
                }
                composable(RouterScreen.MAIN_SCREEN){
                    MainScreen()
                }
            }
        }
    }
}
