package com.richards.jonathan.postapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.PostDetails
import com.richards.jonathan.postapp.domain.usecase.GetAllDataUseCase
import com.richards.jonathan.postapp.domain.usecase.GetCommentCountUseCase
import com.richards.jonathan.postapp.domain.usecase.GetPostDetailsUseCase
import com.richards.jonathan.postapp.domain.usecase.GetPostListUseCase

class PostViewModel constructor(private val getAllDataUseCase: GetAllDataUseCase,
                                private val getPostListUseCase: GetPostListUseCase,
                                private val getPostDetailsUseCase: GetPostDetailsUseCase,
                                private val getCommentCountUseCase: GetCommentCountUseCase) : ViewModel() {

    private lateinit var hasDataBeenFetched: LiveData<Boolean>

    fun getPostList(): LiveData<List<Post>> {
        return getPostListUseCase.getPostList()
    }

    fun getPostDetails(postId: String): LiveData<PostDetails> {
        return getPostDetailsUseCase.getPostDetails(postId)
    }

    fun getCommentCount(postId: String): LiveData<Int> {
        return getCommentCountUseCase.getCommentCount(postId)
    }

    fun fetchAllData(): LiveData<Boolean> {
        hasDataBeenFetched = getAllDataUseCase.fetchAllData()
        return hasDataBeenFetched
    }

}