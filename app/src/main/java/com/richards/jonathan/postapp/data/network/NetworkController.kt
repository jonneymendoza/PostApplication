package com.richards.jonathan.postapp.data.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.richards.jonathan.postapp.BuildConfig
import com.richards.jonathan.postapp.data.entity.Comment
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.User
import com.richards.jonathan.postapp.data.network.contract.NetworkControllerContract
import com.richards.jonathan.postapp.data.network.contract.NetworkHelperContract
import com.richards.jonathan.postapp.data.network.contract.PostApi
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkController constructor(private val networkHelper: NetworkHelperContract) : NetworkControllerContract {

    private fun postApi(): PostApi {
        val gson = GsonBuilder().setLenient().create()
        val httpClient = networkHelper.createHttpClient()
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

        return retrofit.create(PostApi::class.java)
    }

    override fun getPosts(): Deferred<Response<List<Post>>> {
        return postApi().getPosts()
    }

    override fun getUsers(): Deferred<Response<List<User>>> {
        return postApi().getUsers()
    }

    override fun getComments(): Deferred<Response<List<Comment>>> {
        return postApi().getComments()
    }

}