package com.richards.jonathan.postapp.data.network.contract

import okhttp3.OkHttpClient

interface NetworkHelperContract {
    fun createHttpClient(): OkHttpClient
}