package com.richards.jonathan.postapp.main

import android.app.Application
import com.richards.jonathan.postapp.data.DataModule
import com.richards.jonathan.postapp.data.network.di.NetworkModule
import com.richards.jonathan.postapp.domain.DomainModule
import com.richards.jonathan.postapp.ui.di.ViewModule
import org.koin.android.ext.android.startKoin

class PostApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(NetworkModule.getModule,
                DataModule.getModule,
                ViewModule.getModule,
                DomainModule.getModule))
    }
}