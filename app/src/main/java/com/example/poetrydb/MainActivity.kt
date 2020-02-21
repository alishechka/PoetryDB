package com.example.poetrydb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), onItemClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(PoetryViewModel::class.java)
        viewModel.getRepoPoetryByAuth()
        viewModel.authorLiveDataSuccess.observe(this, Observer {
            rv_display.adapter = AuthorAdapter(it)
            rv_display.layoutManager = LinearLayoutManager(this)

        })

    }

    override fun clickedItem(s: String) {
        val intent = Intent(this, PoemActivity::class.java)

    }
}
