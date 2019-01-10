package com.richards.jonathan.postapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.PostDetails

@Dao
interface PostDao {

    @Query("SELECT * FROM Post")
    fun getPosts() : LiveData<List<Post>>

    @Query("SELECT Post.title AS title, Post.body AS body, User.username AS username" +
            "FROM Post, User," +
            "WHERE User.id = Post.userId")
    fun getPostDetails(postId : Int) : LiveData<PostDetails>

    @Query("SELECT COUNT (*) FROM Comment" )
    fun getCommentCount(postId: Int) : LiveData<Int>


}