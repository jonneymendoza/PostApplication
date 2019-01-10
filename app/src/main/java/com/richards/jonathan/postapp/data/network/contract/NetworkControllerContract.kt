package com.richards.jonathan.postapp.data.network.contract

import com.richards.jonathan.postapp.data.entity.Comment
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.User
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface NetworkControllerContract {
    fun getPosts(): Deferred<Response<List<Post>>>
    fun getUsers(): Deferred<Response<List<User>>>
    fun getComments(): Deferred<Response<List<Comment>>>
}