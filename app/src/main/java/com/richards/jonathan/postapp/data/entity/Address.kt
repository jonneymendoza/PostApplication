package com.richards.jonathan.postapp.data.entity

import androidx.room.Embedded

data class Address(val street: String?,
                   val suit: String?,
                   val city: String?,
                   val zipCode: String?,
                   @Embedded val geo: Geo?)