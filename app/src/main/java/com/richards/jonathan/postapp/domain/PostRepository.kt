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
    override fun getCommentCount(postId: String): LiveData<Int> {
        return database.getPostDao().getCommentCount(postId)
    }

    override fun getPosts(): LiveData<List<Post>> {
        return database.getPostDao().getPosts()
    }

    override fun getDetailedPost(postId: String): LiveData<PostDetails> {
        return database.getPostDao().getPostDetails(postId)
    }

    override fun fetchAndSaveData(): MutableLiveData<Boolean> {

        val isComplete = MutableLiveData<Boolean>()

        GlobalScope.launch {

            try {
                val responseUsers = networkController.getUsers().await()
                val responsePost = networkController.getPosts().await()
                val responseComments = networkController.getComments().await()

                if (responseComments.isSuccessful && responsePost.isSuccessful && responseUsers.isSuccessful) {
                    database.getPostDao().saveAllData(responseUsers.body()!!, responsePost.body()!!, responseComments.body()!!)
                    isComplete.postValue(true)
                } else {
                    isComplete.postValue(false)
                }

            } catch (e: Exception) {
                e.printStackTrace()
                //Todo: wrap a error object around this
                isComplete.postValue(false)
            }

        }
        return isComplete

    }

}