package com.android.whatsappclone.model

import com.android.whatsappclone.model.Auth.LoginBody
import com.android.whatsappclone.model.Auth.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject
import javax.inject.Singleton

interface ApiService {
    @POST("auth/signin")
    suspend fun loginUser(
        @Body request: LoginBody
    ): Response<LoginResponse>
}

@Singleton
class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun loginUser(request: LoginBody): Response<LoginResponse> =
        safeApiCall { apiService.loginUser(request) }


    private suspend fun <T> safeApiCall(apiCall: suspend () -> T): T {
        return withContext(Dispatchers.IO) {
            apiCall()
        }
    }

}
