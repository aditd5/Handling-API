package com.aditd5.absen.core.di

import com.aditd5.absen.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { AppRepository(get(), get()) }
}