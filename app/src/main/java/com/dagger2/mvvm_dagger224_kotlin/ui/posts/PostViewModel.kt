package com.dagger2.mvvm_dagger224_kotlin.ui.posts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.dagger2.mvvm_dagger224_kotlin.Resource
import com.dagger2.mvvm_dagger224_kotlin.model.Posts
import com.dagger2.mvvm_dagger224_kotlin.network.main.MainApi
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList
import javax.inject.Inject

class PostViewModel @Inject constructor(val mainApi: MainApi) : ViewModel() {

    companion object{
    val  TAG : String ="PostViewModel"
    }


private var mediatorLiveData : MediatorLiveData<Resource<List<Posts>>> = MediatorLiveData();

    fun getListOfPost(): MediatorLiveData<Resource<List<Posts>>>
    {
        if (mediatorLiveData == null) {
            mediatorLiveData = MediatorLiveData<Resource<List<Posts>>>()
            mediatorLiveData.setValue(Resource.Loading(null as List<Posts>?))
        }

        val reponseSource = LiveDataReactiveStreams.fromPublisher(
            mainApi.getListOfPosts(1)
                .onErrorReturn(Function<Throwable, List<Posts>> { throwable ->
                    Log.d(TAG, " " + throwable.message)
                    val post = Posts()
                    post.setId(-1)
                    val errorList = ArrayList<Posts>()
                    errorList.add(post)
                    errorList
                })
                .map(object : Function<List<Posts>, Resource<List<Posts>>> {

                    @Throws(Exception::class)
                    override fun apply(posts: List<Posts>): Resource<List<Posts>> {
                        if (posts.size > 0) {
                            if (posts[0].id==-1) {
                                return Resource.Error("Error fetching posts", null)
                            }
                        }
                        return Resource.Success(posts)
                    }
                })
                .subscribeOn(Schedulers.io())
        )

        mediatorLiveData.addSource(reponseSource, object : Observer<Resource<List<Posts>>> {
            override fun onChanged(listResource: Resource<List<Posts>>) {
                mediatorLiveData.setValue(listResource)
                mediatorLiveData.removeSource(reponseSource)
            }
        })

        return mediatorLiveData;
    }



}