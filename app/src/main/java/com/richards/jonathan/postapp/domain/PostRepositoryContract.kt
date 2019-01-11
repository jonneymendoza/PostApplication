package com.richards.jonathan.postapp.domain

import androidx.lifecycle.LiveData
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.PostDetails

interface PostRepositoryContract {
    fun fetchAndSaveData(): LiveData<Boolean>
    fun getPosts(): LiveData<List<Post>>
    fun getDetailedPost(postId: String): LiveData<PostDetails>
    fun getCommentCount(postId: String): LiveData<Int>
}