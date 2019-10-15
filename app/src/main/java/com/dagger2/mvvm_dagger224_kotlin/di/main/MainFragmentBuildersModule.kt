package com.dagger2.mvvm_dagger224_kotlin.di.main

import com.dagger2.mvvm_dagger224_kotlin.ui.posts.PostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
 abstract class MainFragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributePostFragment(): PostFragment
}