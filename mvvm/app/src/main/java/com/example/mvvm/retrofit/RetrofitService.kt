package com.example.mvvm.retrofit

import com.example.mvvm.model.Data_Value
import com.example.mvvm.response.ValuesResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface RetrofitService {
    @GET("person")
    fun getAllUser(): Call<ValuesResponse<Data_Value>>

    companion object{
        private var myRetrofit: RetrofitService? = null
        private var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

         fun getClientApi(): RetrofitService {
             if (myRetrofit == null) {
                 val retrofit = Retrofit.Builder()
                     .baseUrl("https://mobile-squad-api.herokuapp.com/")
                     .addConverterFactory(GsonConverterFactory.create())
                     .build()
                 myRetrofit = retrofit.create(RetrofitService::class.java)
             }
             return myRetrofit!!
        }

}
}