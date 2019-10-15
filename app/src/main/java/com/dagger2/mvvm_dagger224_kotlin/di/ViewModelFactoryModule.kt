package com.dagger2.mvvm_dagger224_kotlin.di

import androidx.lifecycle.ViewModelProvider
import com.dagger2.mvvm_dagger224_kotlin.factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
 abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactoryInstance(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory

}