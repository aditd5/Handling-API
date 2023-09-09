package com.aditd5.absen.core.data.source.remote.network

import com.aditd5.absen.core.data.source.remote.request.LoginRequest
import com.aditd5.absen.core.data.source.remote.response.LoginResponse
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(          //suspend agar bisa melakukan proses ke background
//        @Field("email") email: String,
//        @Field("password") password: String
        @Body login: LoginRequest
    ): Response<LoginResponse>
}