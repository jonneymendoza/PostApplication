package com.richards.jonathan.postapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.richards.jonathan.postapp.data.entity.Comment
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.PostDetails
import com.richards.jonathan.postapp.data.entity.User

@Dao
abstract class PostDao {

    @Query("SELECT * FROM post")
    abstract fun getPosts(): LiveData<List<Post>>

    //    @Query("SELECT post.title AS title, post.body AS body, post.username AS username" +
//            "FROM post, user, " +
//            "WHERE user.id = post.userId")
    @Query("SELECT post.title, post.body, user.username" +
            " FROM post" +
            " INNER JOIN user" +
            " ON post.userId=user.id" +
            " WHERE post.id = :postId")
    abstract fun getPostDetails(postId: String): LiveData<PostDetails>

    @Query("SELECT COUNT (*) FROM comment WHERE postId = :postId")
    abstract fun getCommentCount(postId: String): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun savePosts(posts: List<Post>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun saveComments(comments: List<Comment>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun saveUsers(users: List<User>)

    @Transaction
    open fun saveAllData(users: List<User>, posts: List<Post>, comments: List<Comment>) {

        saveUsers(users)
        savePosts(posts)
        saveComments(comments)
    }


}