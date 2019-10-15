package com.dagger2.mvvm_dagger224_kotlin.network.main

import com.dagger2.mvvm_dagger224_kotlin.model.Posts
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    // /posts?userId=1
    @GET("posts")
    fun getListOfPosts(@Query("userId") userId : Int) : Flowable<List<Posts>>
}