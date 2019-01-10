package com.richards.jonathan.postapp.data.network.contract

import com.richards.jonathan.postapp.data.entity.Comment
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.User
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    fun getPosts(): Deferred<Response<List<Post>>>

    @GET("users")
    fun getUsers(): Deferred<Response<List<User>>>

    @GET("comments")
    fun getComments(): Deferred<Response<List<Comment>>>
}