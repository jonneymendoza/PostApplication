package com.richards.jonathan.postapp.data.network.contract

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    fun getPosts(): Deferred<*>

    @GET("users")
    fun getUsers(): Deferred<*>

    @GET("comments")
    fun getComments(): Deferred<*>
}