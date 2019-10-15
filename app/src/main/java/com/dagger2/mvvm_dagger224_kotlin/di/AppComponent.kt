package com.dagger2.mvvm_dagger224_kotlin.di

import android.app.Application
import com.dagger2.mvvm_dagger224_kotlin.BaseApplicationClass
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
                      ActivityBuilderModule::class,
                      AppModule::class,
                      ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<BaseApplicationClass>{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun myApplication(application: Application) : Builder
        fun build() : AppComponent
    }
}