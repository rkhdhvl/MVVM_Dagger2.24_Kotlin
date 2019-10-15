package com.dagger2.mvvm_dagger224_kotlin

import com.dagger2.mvvm_dagger224_kotlin.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class BaseApplicationClass : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        // Binding the application instance to the application component
        return DaggerAppComponent.builder().myApplication(this).build()
    }
}


