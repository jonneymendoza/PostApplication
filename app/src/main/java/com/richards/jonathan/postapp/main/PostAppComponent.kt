package com.richards.jonathan.postapp.main

import com.richards.jonathan.postapp.data.DataModule
import com.richards.jonathan.postapp.data.network.di.NetworkModule
import com.richards.jonathan.postapp.domain.DomainModule
import com.richards.jonathan.postapp.ui.di.ViewModule

object PostAppComponent {
    val getAllModules = listOf(NetworkModule.getModule,
            DataModule.getModule,
            ViewModule.getModule,
            DomainModule.getModule)
}