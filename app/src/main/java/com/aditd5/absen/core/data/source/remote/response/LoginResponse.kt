package com.aditd5.absen.core.data.source.remote.response

import com.aditd5.absen.core.data.source.model.User

data class LoginResponse(
    val code: Int? = null,
    val message: String? = null,
    val data: User? = null
)