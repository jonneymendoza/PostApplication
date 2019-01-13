package com.richards.jonathan.postapp

import android.content.Context
import androidx.room.Room
import com.richards.jonathan.postapp.data.database.PostDatabase
import com.richards.jonathan.postapp.data.network.contract.NetworkControllerContract
import com.richards.jonathan.postapp.domain.PostRepository
import com.richards.jonathan.postapp.domain.PostRepositoryContract
import com.richards.jonathan.postapp.domain.usecase.GetAllDataUseCase
import com.richards.jonathan.postapp.domain.usecase.GetCommentCountUseCase
import com.richards.jonathan.postapp.domain.usecase.GetPostDetailsUseCase
import com.richards.jonathan.postapp.domain.usecase.GetPostListUseCase
import org.koin.dsl.module.module
import org.koin.experimental.builder.create
import org.mockito.Mockito

object TestModule {
    fun testModules(context: Context) = module {
        single<NetworkControllerContract> {
            Mockito.mock(NetworkControllerContract::class.java)
        }
        single {
            Room.inMemoryDatabaseBuilder(context,
                    PostDatabase::class.java).allowMainThreadQueries().build()
        }
        single<PostRepositoryContract> { PostRepository(get(), get()) }
//            factory { GetAllDataUseCase(get()) }
        single { create<GetAllDataUseCase>() }
        single { GetCommentCountUseCase(get()) }
        single { GetPostDetailsUseCase(get()) }
        single { GetPostListUseCase(get()) }
    }
}