package com.android.whatsappclone.model

import com.android.whatsappclone.model.auth.LoginBody
import com.android.whatsappclone.model.auth.LoginResponse
import com.android.whatsappclone.model.chat.GetDataChat
import com.android.whatsappclone.model.chat.ResponseListChat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

interface ApiService {
    @POST("auth/signin")
    suspend fun loginUser(
        @Body request: LoginBody
    ): Response<LoginResponse>

    @GET("chat")
    suspend fun getListChat(
        @Header("Authorization") token: String
    ): Response<ResponseListChat>
}

@Singleton
class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun loginUser(request: LoginBody): Response<LoginResponse> =
        safeApiCall { apiService.loginUser(request) }

    suspend fun getListChat(token:String): Response<ResponseListChat> =
        safeApiCall { apiService.getListChat(token = token)}


    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): T {
        return withContext(Dispatchers.IO) {
            apiCall()
        }
    }

}
