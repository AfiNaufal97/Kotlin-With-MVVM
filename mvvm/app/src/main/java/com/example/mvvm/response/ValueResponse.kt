package com.example.mvvm.response

// generic T akan memiliki type data Data_Value
data class ValueResponse<T>(
    var msg:String,
    var status:Int,
    var data:T
)
