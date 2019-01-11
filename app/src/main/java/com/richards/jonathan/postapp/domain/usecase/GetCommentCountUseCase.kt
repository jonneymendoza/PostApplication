package com.richards.jonathan.postapp.domain.usecase

import androidx.lifecycle.LiveData
import com.richards.jonathan.postapp.domain.PostRepositoryContract

class GetCommentCountUseCase constructor(private val repositoryContract: PostRepositoryContract) {

    fun getCommentCount(postId: String): LiveData<Int> {
        return repositoryContract.getCommentCount(postId)
    }
}