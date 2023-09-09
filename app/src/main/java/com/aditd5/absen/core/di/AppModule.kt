package com.aditd5.absen.core.di

import com.aditd5.absen.core.data.source.local.LocalDataSource
import com.aditd5.absen.core.data.source.remote.RemoteDataSource
import com.aditd5.absen.core.data.source.remote.network.ApiConfig
import org.koin.dsl.module

val appModule = module {
    single { ApiConfig.provideApiService }
    single { RemoteDataSource(get()) }
    single { LocalDataSource() }

}