package com.richards.jonathan.postapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.richards.jonathan.postapp.data.entity.Comment
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.PostDetails
import com.richards.jonathan.postapp.data.entity.User

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    fun getPosts(): LiveData<List<Post>>

    @Query("SELECT post.title AS title, post.body AS body, post.username AS username" +
            "FROM post, user, " +
            "WHERE user.id = post.userId")
    fun getPostDetails(postId: Int): LiveData<PostDetails>

    @Query("SELECT COUNT (*) FROM comment WHERE postId = :postId")
    fun getCommentCount(postId: Int): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePosts(posts: List<Post>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveComments(comments: List<Comment>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUsers(users: List<User>)


}