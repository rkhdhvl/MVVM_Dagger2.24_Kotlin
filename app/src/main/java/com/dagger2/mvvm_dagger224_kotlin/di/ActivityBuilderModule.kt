package com.dagger2.mvvm_dagger224_kotlin.di

import com.dagger2.mvvm_dagger224_kotlin.di.main.MainFragmentBuildersModule
import com.dagger2.mvvm_dagger224_kotlin.di.main.MainModule
import com.dagger2.mvvm_dagger224_kotlin.di.main.MainScope
import com.dagger2.mvvm_dagger224_kotlin.di.main.MainViewModelModule
import com.dagger2.mvvm_dagger224_kotlin.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

// MainFragmentBuildersModule::class

@Module
 abstract class  ActivityBuilderModule {

    @MainScope
    @ContributesAndroidInjector(
        modules = [MainModule::class,
            MainViewModelModule::class,
            MainFragmentBuildersModule::class]
    )
   abstract fun contributeMainActivity() : MainActivity

}