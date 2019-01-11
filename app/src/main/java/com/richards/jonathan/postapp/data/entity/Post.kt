package com.richards.jonathan.postapp.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "post",
        foreignKeys = arrayOf(ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("userId"),
        onDelete = ForeignKey.CASCADE
)))
data class Post(var userId: Int,
                @PrimaryKey var id: Int,
                var title: String,
                var body: String)