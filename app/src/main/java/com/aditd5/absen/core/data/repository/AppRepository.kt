package com.aditd5.absen.core.data.repository

import android.util.Log
import com.aditd5.absen.core.data.source.local.LocalDataSource
import com.aditd5.absen.core.data.source.remote.RemoteDataSource
import com.aditd5.absen.core.data.source.remote.network.Resource
import com.aditd5.absen.core.data.source.remote.request.LoginRequest
import com.inyongtisto.myhelper.extension.getErrorBody
import kotlinx.coroutines.flow.flow


class AppRepository(val local: LocalDataSource, val remote: RemoteDataSource) {

    fun login(data: LoginRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.login(data).let {
                if (it.isSuccessful) {
                    val body = it.body()
                    emit(Resource.success(body?.data))

                    Log.d("TAG", "Success:" + body.toString())
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?: "Error default", null))
                    Log.d("TAG", "Error:" + "Keterangan error")
                }
            }
        } catch (e:Exception) {
            emit(Resource.error(e.message?: "Terjadi Kesalahan", null))
            Log.d("TAG", "login: error" + e.message)
        }
    }
}