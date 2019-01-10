package com.richards.jonathan.postapp.main

import android.app.Application
import com.richards.jonathan.postapp.data.network.di.NetworkModule
import org.koin.android.ext.android.startKoin

class PostApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(NetworkModule.getModule))
    }
}