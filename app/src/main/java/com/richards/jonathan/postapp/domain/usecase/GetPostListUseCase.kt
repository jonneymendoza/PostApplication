package com.richards.jonathan.postapp.domain.usecase

import androidx.lifecycle.LiveData
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.domain.PostRepositoryContract

class GetPostListUseCase  constructor(private val postRepositoryContract: PostRepositoryContract){

    fun getPostList() : LiveData<List<Post>>{
        return postRepositoryContract.getPosts()
    }
}