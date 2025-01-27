package com.android.whatsappclone.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.whatsappclone.model.auth.AuthPreferencesKeys
import com.android.whatsappclone.model.auth.LoginBody
import com.android.whatsappclone.model.auth.LoginResponse
import com.android.whatsappclone.model.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_preferences")

@HiltViewModel
open class AuthViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    var isLoading = mutableStateOf(false)
        private set
    var email = mutableStateOf("")
        private set
    var password = mutableStateOf("")
        private set
    var token = mutableStateOf("")
        private set
    var username = mutableStateOf("")
        private set

    init {
        viewModelScope.launch {
            context.dataStore.data.collect { preferences ->
                token.value = preferences[AuthPreferencesKeys.TOKEN] ?: ""
//                email.value = preferences[AuthPreferencesKeys.EMAIL] ?: ""
//                password.value = preferences[AuthPreferencesKeys.PASSWORD] ?: ""
            }
        }
    }

    fun setIsLoading() {
        isLoading.value = !isLoading.value
    }

    fun setEmail(email: String) {
        this.email.value = email
    }

    fun setPassword(password: String) {
        this.password.value = password
    }

    fun setToken(token: String) {
        this.token.value = token
    }

    fun setUsername(username: String) {
        this.username.value = username
    }

    fun saveToken(token: String) = viewModelScope.launch {
        context.dataStore.edit { preferences ->
            preferences[AuthPreferencesKeys.TOKEN] = token
        }
    }

    fun saveEmail(email: String) = viewModelScope.launch {
        context.dataStore.edit { preferences ->
            preferences[AuthPreferencesKeys.EMAIL] = email
        }
    }

    fun savePassword(password: String) = viewModelScope.launch {
        context.dataStore.edit { preferences ->
            preferences[AuthPreferencesKeys.PASSWORD] = password
        }
    }

    fun getTokenFlow(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[AuthPreferencesKeys.TOKEN] ?: ""
        }
    }

    fun onLogin(onSuccessLogin: () -> Unit) {
        viewModelScope.launch {
            try {
                setIsLoading()
                val response = mainRepository.loginUser(
                    LoginBody(
                        username.value.toString(),
                        password.value.toString()
                    )
                )
                println("LOGIN SUCCESS: " + response.body())
                if (response.isSuccessful) {
                    val loginResponse = LoginResponse(response.body()?.token ?: "")
                    setToken(loginResponse.token)
                    saveToken(loginResponse.token)
                    onSuccessLogin()
                }
            } catch (e: Exception) {
                println("LOGIN ERROR: " + e.message)
            } finally {
                setIsLoading()
            }
        }
    }
}