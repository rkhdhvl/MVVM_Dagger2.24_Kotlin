package com.dagger2.mvvm_dagger224_kotlin.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.ElementType
import kotlin.reflect.KClass

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)