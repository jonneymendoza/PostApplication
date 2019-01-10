package com.richards.jonathan.postapp.data

import androidx.room.Room
import com.richards.jonathan.postapp.data.database.PostDatabase
import org.koin.dsl.module.module

object DataModule {
    val getModule = module {
        single {
            Room.databaseBuilder(get(), PostDatabase::class.java, "postDb").allowMainThreadQueries().build()
        }
    }
}