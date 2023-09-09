package com.aditd5.absen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aditd5.absen.core.data.repository.AppRepository
import com.aditd5.absen.core.data.source.remote.request.LoginRequest

class LoginViewModel(val repo: AppRepository): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hi, Im a Developer"
    }
    val text: LiveData<String> = _text

//    fun ubahData() {
//        _text.postValue("Scania Opticruise")
//    }

    fun login(data: LoginRequest) = repo.login(data).asLiveData()
}