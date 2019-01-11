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

        GlobalScope.launch {

            try {

            } catch (e: Exception) {
                e.printStackTrace()
                //Todo: wrap a error object around this
                isComplete.postValue(false)
            }

            val responsePost = networkController.getPosts().await()
            val responseComments = networkController.getComments().await()
            val responseUsers = networkController.getUsers().await()

            if (responseComments.isSuccessful && responsePost.isSuccessful && responseUsers.isSuccessful) {
                database.getPostDao().saveComments(responseComments.body()!!)
                database.getPostDao().savePosts(responsePost.body()!!)
                database.getPostDao().saveUsers(responseUsers.body()!!)
                isComplete.postValue(true)
            } else {
                isComplete.postValue(false)
            }
        }


        return isComplete

    }

}