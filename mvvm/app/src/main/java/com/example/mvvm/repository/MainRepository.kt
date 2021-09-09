package com.example.mvvm.repository

import com.example.mvvm.retrofit.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllUsers() = retrofitService.getAllUser()
}