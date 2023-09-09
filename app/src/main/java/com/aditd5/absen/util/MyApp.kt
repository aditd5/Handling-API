package com.aditd5.absen.util

import android.app.Application
import com.aditd5.absen.core.di.appModule
import com.aditd5.absen.core.di.repositoryModule
import com.aditd5.absen.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, viewModelModule, repositoryModule))
        }
    }
}