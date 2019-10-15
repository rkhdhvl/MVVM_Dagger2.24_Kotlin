package com.dagger2.mvvm_dagger224_kotlin.ui.posts


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.dagger2.mvvm_dagger224_kotlin.R
import com.dagger2.mvvm_dagger224_kotlin.Resource
import com.dagger2.mvvm_dagger224_kotlin.factory.ViewModelProviderFactory
import com.dagger2.mvvm_dagger224_kotlin.ui.posts.PostViewModel.Companion.TAG
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class PostFragment : DaggerFragment() {

    @Inject
    internal lateinit var viewModelProviderFactory: ViewModelProviderFactory

    lateinit var postViewModel: PostViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.posts_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(PostViewModel::class.java)
        subscribeObservers()
    }

    private fun subscribeObservers()
    {
       postViewModel.getListOfPost().removeObserver { viewLifecycleOwner }
       postViewModel.getListOfPost().observe(viewLifecycleOwner, Observer {
          if(!it.data.isNullOrEmpty())
          {
              Log.d(TAG, it.data.get(0).getTitle())
              /*when (it) {

                  Resource.LOADING -> {
                      Log.d(TAG, "onChanged: LOADING...")
                  }

                  Resource.SUCCESS -> {
                      Log.d(TAG, "onChanged: got posts...")
                      Log.d(TAG, it.data.get(0).getTitle())
                  }

                  Resource.ERROR -> {
                      Log.e(TAG, "onChanged: ERROR..." + it.message)
                  }
              }*/
          }
       })
    }

}
