package com.android.whatsappclone.viewmodel

import android.content.Context
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.whatsappclone.model.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ChatViewModel @Inject constructor(
    private val mainRepository: MainRepository,
) : ViewModel() {

    var isLoading = mutableStateOf(false)
        private set

    fun onGetListChat() {
        viewModelScope.launch(){
//            val token = AuthViewModel.getTokenFlow()
//            println("TOKEN: " + token)
        }
    }
}