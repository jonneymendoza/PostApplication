package com.richards.jonathan.postapp.domain

import androidx.lifecycle.LiveData
import com.richards.jonathan.postapp.data.database.PostDatabase
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.PostDetails
import com.richards.jonathan.postapp.data.network.NetworkCallHelper
import com.richards.jonathan.postapp.data.network.contract.NetworkControllerContract

class PostRepository constructor(private val networkController: NetworkControllerContract,
                                 private val database: PostDatabase) : PostRepositoryContract {
    override fun getCommentCount(postId: Int): LiveData<Int> {
        return database.getPostDao().getCommentCount(postId)
    }

    override fun getPosts(): LiveData<List<Post>> {
        return database.getPostDao().getPosts()
    }

    override fun getDetailedPost(postId: Int): LiveData<PostDetails> {
        return database.getPostDao().getPostDetails(postId)
    }

    override fun fetchAndSaveData(): Boolean {
        val postResponse = NetworkCallHelper<List<Post>>().makeCall(networkController.getPosts())

        postResponse.observe()

    }

}