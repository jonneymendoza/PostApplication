package com.richards.jonathan.postapp.domain

import com.richards.jonathan.postapp.domain.usecase.GetAllDataUseCase
import com.richards.jonathan.postapp.domain.usecase.GetCommentCountUseCase
import com.richards.jonathan.postapp.domain.usecase.GetPostDetailsUseCase
import com.richards.jonathan.postapp.domain.usecase.GetPostListUseCase
import org.koin.dsl.module.module

object DomainModule {
    val getModule = module {
        factory { GetAllDataUseCase(get()) }
        factory { GetCommentCountUseCase(get()) }
        factory { GetPostDetailsUseCase(get()) }
        factory { GetPostListUseCase(get()) }
        factory<PostRepositoryContract> { PostRepository(get(), get()) }
    }
}