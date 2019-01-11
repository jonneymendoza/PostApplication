package com.richards.jonathan.postapp.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(@PrimaryKey var id: String,
                var name: String,
                var username: String,
                var email: String,
                @Embedded var address: Address,
                val phone: String,
                val website: String,
                @Embedded(prefix = "company") val company: Company)