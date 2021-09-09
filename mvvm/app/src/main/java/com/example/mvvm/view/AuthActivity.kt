package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm.R
import com.example.mvvm.adapter.AdapterViewPagger
import com.example.mvvm.databinding.ActivityAuthBinding
import com.google.android.material.tabs.TabLayoutMediator

class AuthActivity : AppCompatActivity() {

    private lateinit var authBinding: ActivityAuthBinding
    companion object{
        private val TAB_TITLE = intArrayOf(
            R.string.login,
            R.string.register
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authBinding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(authBinding.root)

        setViewPagger()
    }

    private fun setViewPagger(){
        val vp = authBinding.vpHome
        val adapterVp = AdapterViewPagger(this)
        val tbLayout = authBinding.tabLayout
        vp.adapter = adapterVp
        TabLayoutMediator(tbLayout, vp){
            tab, position -> tab.text = resources.getString(TAB_TITLE[position])
        }.attach()
    }
}