package com.richards.jonathan.postapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "comment",
        foreignKeys = arrayOf(ForeignKey(
        entity = Post::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("postId")
)))
data class Comment(val postId: String,
                   @PrimaryKey val id: String,
                   val name: String,
                   val email: String,
                   val body: String)