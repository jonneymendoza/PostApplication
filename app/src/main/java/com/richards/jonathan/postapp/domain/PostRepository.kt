package com.richards.jonathan.postapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.richards.jonathan.postapp.data.database.PostDatabase
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.PostDetails
import com.richards.jonathan.postapp.data.network.contract.NetworkControllerContract
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

    override fun fetchAndSaveData(): MutableLiveData<Boolean> {

        val isComplete = MutableLiveData<Boolean>()

//        val postResponse =


        GlobalScope.launch {

            var responsePost = networkController.getPosts().await()
            var responseComments = networkController.getComments().await()
            var responseUsers = networkController.getUsers().await()

            if (responseComments.isSuccessful && responsePost.isSuccessful && responseUsers.isSuccessful ){

            }
        }


        return isComplete

    }

}