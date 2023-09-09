package com.aditd5.absen.core.data.source.remote.request

import com.aditd5.absen.core.data.source.model.User

data class LoginRequest(
    val email: String,
    val password: String
)