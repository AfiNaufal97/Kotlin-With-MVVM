package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm.databinding.ActivityDetailBarangBinding

class DetailBarangActivity : AppCompatActivity() {

    private lateinit var detailBarangBinding: ActivityDetailBarangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBarangBinding = ActivityDetailBarangBinding.inflate(layoutInflater)
        setContentView(detailBarangBinding.root)
    }
}