package com.richards.jonathan.postapp.data.network.di

import com.richards.jonathan.postapp.data.network.NetworkController
import com.richards.jonathan.postapp.data.network.NetworkHelper
import com.richards.jonathan.postapp.data.network.contract.NetworkControllerContract
import com.richards.jonathan.postapp.data.network.contract.NetworkHelperContract
import org.koin.dsl.module.module

object NetworkModule {
    val getModule = module {
        single<NetworkHelperContract> { NetworkHelper() }
        single<NetworkControllerContract> { NetworkController(get()) }
    }
}