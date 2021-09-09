package com.example.mvvm.response

// generic T akan memiliki type data Data_Value
data class ValuesResponse<T>(
    var msg:String,
    var status:Int,
    var data:List<T>
)