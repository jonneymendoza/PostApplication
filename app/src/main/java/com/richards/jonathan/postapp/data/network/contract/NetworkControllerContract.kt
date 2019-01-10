package com.richards.jonathan.postapp.data.network.contract

import kotlinx.coroutines.Deferred
import retrofit2.Response

interface NetworkControllerContract{
    fun getPosts(): Deferred<Response<*>>
    fun getUsers(): Deferred<Response<*>>
    fun getComments(): Deferred<Response<*>>
}