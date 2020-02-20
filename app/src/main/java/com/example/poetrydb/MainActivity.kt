package com.example.poetrydb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel=ViewModelProvider(this).get(PoetryViewModel::class.java)

        viewModel.authorLiveDataSuccess.observe(this, Observer {
            //recycler here and stuff
        })

    }
}
