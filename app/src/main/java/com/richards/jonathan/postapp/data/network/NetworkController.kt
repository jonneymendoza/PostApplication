package com.richards.jonathan.postapp.data.network

import com.richards.jonathan.postapp.data.network.contract.NetworkControllerContract
import com.richards.jonathan.postapp.data.network.contract.NetworkHelperContract
import kotlinx.coroutines.Deferred
import retrofit2.Response

class NetworkController constructor(private val networkHelper: NetworkHelperContract) : NetworkControllerContract {
    override fun getPosts(): Deferred<Response<*>> {

    }

    override fun getUsers(): Deferred<Response<*>> {
    }

    override fun getComments(): Deferred<Response<*>> {
    }

}