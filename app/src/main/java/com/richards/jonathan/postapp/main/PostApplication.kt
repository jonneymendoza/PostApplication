package com.richards.jonathan.postapp.main

import android.app.Application
import com.richards.jonathan.postapp.main.PostAppComponent.getAllModules
import org.koin.android.ext.android.startKoin

class PostApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, getAllModules)
    }
}