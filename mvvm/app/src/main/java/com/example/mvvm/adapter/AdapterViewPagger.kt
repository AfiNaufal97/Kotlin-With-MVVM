package com.example.mvvm.adapter

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mvvm.view.fragments.LoginFragment
import com.example.mvvm.view.fragments.RegisterFragment

class AdapterViewPagger(activity: FragmentActivity):FragmentStateAdapter(activity){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment:Fragment? = null

        when(position){
            0-> fragment = LoginFragment()
            else -> fragment = RegisterFragment()
        }
        return fragment
    }
}