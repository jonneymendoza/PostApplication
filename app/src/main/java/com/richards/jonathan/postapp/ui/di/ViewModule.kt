package com.richards.jonathan.postapp.ui.di

import com.richards.jonathan.postapp.ui.viewmodel.PostViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object ViewModule {

    val getModule = module {
        viewModel { PostViewModel(get(), get(), get(), get()) }
    }
}