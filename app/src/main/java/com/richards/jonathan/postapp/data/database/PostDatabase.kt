package com.richards.jonathan.postapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.richards.jonathan.postapp.data.entity.Comment
import com.richards.jonathan.postapp.data.entity.Post
import com.richards.jonathan.postapp.data.entity.User

@Database(entities = arrayOf(Post::class, User::class, Comment::class),
        version = 1)
abstract class PostDatabase : RoomDatabase() {
    abstract fun getPostDao(): PostDao
}