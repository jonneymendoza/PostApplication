package com.richards.jonathan.postapp.domain.usecase

import androidx.lifecycle.LiveData
import com.richards.jonathan.postapp.data.entity.PostDetails
import com.richards.jonathan.postapp.domain.PostRepositoryContract

class GetPostDetailsUseCase constructor(private val repository: PostRepositoryContract) {

    fun getPostDetails(postId: Int): LiveData<PostDetails> {
        return repository.getDetailedPost(postId)
    }
}