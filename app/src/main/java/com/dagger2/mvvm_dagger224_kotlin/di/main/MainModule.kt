package com.dagger2.mvvm_dagger224_kotlin.di.main

import com.dagger2.mvvm_dagger224_kotlin.network.main.MainApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MainModule {

    @MainScope
    @Provides
    fun mainApiInstance(retrofit: Retrofit): MainApi {
        return retrofit.create(MainApi::class.java)
    }
}