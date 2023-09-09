package com.aditd5.absen.core.data.source.remote

import com.aditd5.absen.core.data.source.remote.network.ApiService
import com.aditd5.absen.core.data.source.remote.request.LoginRequest

class RemoteDataSource(private val api: ApiService) {

//    suspend fun login(name: String, password: String) = api.login(data/
    suspend fun login(data: LoginRequest) = api.login(data)
}
