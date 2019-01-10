package com.richards.jonathan.postapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(ForeignKey(
        entity = Post::class,
        parentColumns = arrayOf("postId"),
        childColumns = arrayOf("id")
)))
data class Comment(val postId: Int,
                   @PrimaryKey val id: Int,
                   val name: String,
                   val email: String,
                   val body: String)