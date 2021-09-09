package com.example.mvvm.view

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.adapter.MainAdapter
import com.example.mvvm.databinding.ActivityHomeBinding
import com.example.mvvm.repository.MainRepository
import com.example.mvvm.retrofit.RetrofitService
import com.example.mvvm.viewmodel.MainViewModel
import com.example.mvvm.viewmodel.MyViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding
    private lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getClientApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        viewModel.userList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            homeBinding.rvListProduct.apply {
                val adapterUser = MainAdapter(it)
                setHasFixedSize(true)
                adapter = adapterUser
                layoutManager = LinearLayoutManager(this@HomeActivity)
            }
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllUsers()
    }
}