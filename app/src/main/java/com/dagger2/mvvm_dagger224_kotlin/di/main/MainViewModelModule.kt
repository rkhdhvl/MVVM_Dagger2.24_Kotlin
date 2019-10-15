package com.dagger2.mvvm_dagger224_kotlin.di.main

import androidx.lifecycle.ViewModel
import com.dagger2.mvvm_dagger224_kotlin.di.ViewModelKey
import com.dagger2.mvvm_dagger224_kotlin.ui.posts.PostViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class MainViewModelModule  {

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun providePostViewModel(postViewModel: PostViewModel):ViewModel

}