package com.dicoding.stopjudol.api


import com.dicoding.stopjudol.models.UserResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val username: String, val password: String)
data class RegisterRequest(val username: String, val email: String, val password: String)

interface ApiService {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<UserResponse>

    @POST("register")
    fun register(@Body request: RegisterRequest): Call<ResponseBody>
}
