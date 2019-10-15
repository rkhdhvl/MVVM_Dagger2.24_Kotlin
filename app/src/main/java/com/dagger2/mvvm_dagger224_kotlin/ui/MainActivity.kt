package com.dagger2.mvvm_dagger224_kotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dagger2.mvvm_dagger224_kotlin.BaseActivity
import com.dagger2.mvvm_dagger224_kotlin.R
import com.dagger2.mvvm_dagger224_kotlin.ui.posts.PostFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(PostFragment())
    }

    fun loadFragment(fragment: Fragment?) {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_container, fragment)
                .commit()
        }
    }

}
