package com.android.whatsappclone.model.Auth

import androidx.datastore.preferences.core.stringPreferencesKey

object AuthPreferencesKeys {
    val TOKEN = stringPreferencesKey("token")
    val EMAIL = stringPreferencesKey("email")
    val PASSWORD = stringPreferencesKey("password")
}