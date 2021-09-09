package com.example.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.Data_Value
import com.example.mvvm.repository.MainRepository
import com.example.mvvm.response.ValuesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val userList = MutableLiveData<List<Data_Value>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllUsers() {
        val response = repository.getAllUsers()
        response.enqueue(object : Callback<ValuesResponse<Data_Value>> {
            override fun onResponse(
                call: Call<ValuesResponse<Data_Value>>,
                response: Response<ValuesResponse<Data_Value>>
            ) {
                if(response.isSuccessful){
                    val body = response.body()!!.data
                        userList.postValue(body)

                }
            }

            override fun onFailure(
                call: Call<com.example.mvvm.response.ValuesResponse<Data_Value>>,
                t: Throwable
            ) {
                errorMessage.postValue(t.message)
            }

        })
    }
}